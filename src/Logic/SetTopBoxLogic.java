package Logic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.SetTopBox;
import utility.JdbcDTH;

public class SetTopBoxLogic {

	// Display information about all Set Top Boxes
	public List<SetTopBox> view() {

		// Create SetTopBoxModel Object
		List<SetTopBox> STBMList = new ArrayList<>();

		try {

			// Create query to get information about all Set Top Boxes
			String viewQuery = "SELECT * FROM SetTopBox";
			SetTopBox STBM;
			// Call utility class to connect to the database and receive ResultSet object
			ResultSet SetTopBoxInfo = JdbcDTH.executeDTHQueries(viewQuery);
			String featuresQuery;
			ResultSet featureId;
			String featureQuery;
			ResultSet feature;
			List<String> featureList;

			while (SetTopBoxInfo.next()) {

				STBM = new SetTopBox();
				featureList = new ArrayList<>();
				STBM.setSTBType(SetTopBoxInfo.getString(2));
				STBM.setSTBlength(SetTopBoxInfo.getInt(3));
				STBM.setSTBbreadth(SetTopBoxInfo.getInt(4));
				STBM.setSTBwidth(SetTopBoxInfo.getInt(5));
				STBM.setPrice(SetTopBoxInfo.getDouble(6));
				STBM.setInstallationCharges(SetTopBoxInfo.getDouble(7));
				STBM.setUpdationCharges(SetTopBoxInfo.getDouble(8));
				STBM.setPercentageDiscount(SetTopBoxInfo.getInt(9));
				STBM.setBillingType(SetTopBoxInfo.getString(10));
				STBM.setRefundAmount(SetTopBoxInfo.getDouble(11));

				featuresQuery = "Select featureId from SETTOPBOX_FEATURE where setTopBoxId=" + SetTopBoxInfo.getInt(1);
				featureId = JdbcDTH.executeDTHQueries(featuresQuery);
				while (featureId.next()) {
					featureQuery = "Select featureName from feature where featureId=" + featureId.getInt(1);
					feature = JdbcDTH.executeDTHQueries(featureQuery);
					while (feature.next()) {
						featureList.add(feature.getString(1));
					}
				}

				STBM.setSTBFeatures(featureList);

				STBMList.add(STBM);

			}
			// Return a list of SetTopBoxModel Objects
			System.out.println("Success");
			return STBMList;
		} catch (Exception e) {
			System.err.println("Exception thrown : " + e);
		}
		// Return empty list of SetTopBoxModel Objects
		System.out.println("Failure");
		return STBMList;
	}

	// Add new Set Top Box
	public boolean addSetTopBox(String type, int length, int breadth, int width, double price, double installCharges,
			double updationCharges, int percentDiscount, String billingType, double refund, List<String> features) {

		try {
			ResultSet boxId;
			ResultSet featureId;
			String featureIdQuery;
			String addFeature;
			// Create query to insert new Set Top Box into SetTopBox Table
			String addSTB = "INSERT INTO SetTopBox VALUES (frequency_seq.nextval," + "'" + type + "'" + "," + length
					+ "," + breadth + "," + width + "," + price + "," + installCharges + "," + updationCharges + ","
					+ percentDiscount + "," + "'" + billingType + "'" + "," + refund + ")";

			// Call utility class to connect to the database and receive ResultSet object
			ResultSet STBAdded = JdbcDTH.executeDTHQueries(addSTB);
			String boxIdQuery = "SELECT SetTopBoxId FROM SetTopBox WHERE STBType=" + "'" + type + "'";

			boxId = JdbcDTH.executeDTHQueries(boxIdQuery);
			while (boxId.next()) {

				for (int i = 0; i < features.size(); i++) {

					featureIdQuery = "SELECT featureId FROM feature WHERE featureName=" + "'" + features.get(i) + "'";
					featureId = JdbcDTH.executeDTHQueries(featureIdQuery);
					while (featureId.next()) {
						// Create query to insert features for new Set Top Box into settopbox_feature
						// Table
						addFeature = "INSERT INTO SetTopBox_Feature VALUES (" + boxId.getInt(1) + ","
								+ featureId.getInt(1) + ")";

						// Call utility class to connect to the database and receive ResultSet object
						JdbcDTH.executeDTHQueries(addFeature);
					}
				}
			}
			return true;

		} catch (Exception e) {
			System.err.println("Exception thrown : " + e);
		}
		return false;

	}

	// Update already existing Set Top Box
	public boolean updateSetTopBox(String oldType, String newType, int length, int breadth, int width, double price,
			double installCharges, double updationCharges, int percentDiscount, String billingType, double refund,
			List<String> features) {

		try {

			// Get the id of the SetTopBox we want to update
			String boxId = "SELECT setTopBoxId FROM SetTopBox WHERE STBType='" + oldType + "'";
			ResultSet id = JdbcDTH.executeDTHQueries(boxId);
			String featureIdQuery;
			ResultSet featureId;
			String deleteFeature;
			String insertFeature;
			while (id.next()) {
				// Create query to update information about particular Set Top Box
				String updateQuery = "UPDATE SetTopBox SET" + " STBType=" + "'" + newType + "'" + ",STBlength=" + length
						+ ",STBbreadth=" + breadth + ",STBwidth=" + width + ",price=" + price + ",installationCharges="
						+ installCharges + ",updationCharges=" + updationCharges + ",percentageDiscount="
						+ percentDiscount + ",billingType=" + "'" + billingType + "'" + ",refundAmount=" + refund
						+ " WHERE setTopBoxId=" + id.getInt(1);
				System.out.println(updateQuery);
				// Call utility class to connect to the database and receive ResultSet object
				JdbcDTH.executeDTHQueries(updateQuery);
				System.out.println(features);
				deleteFeature = "Delete from SETTOPBOX_FEATURE where settopboxId=" + id.getInt(1);
				JdbcDTH.executeDTHQueries(deleteFeature);
				for (int i = 0; i < features.size(); i++) {
					featureIdQuery = "SELECT featureId FROM feature WHERE featureName=" + "'" + features.get(i) + "'";
					featureId = JdbcDTH.executeDTHQueries(featureIdQuery);
					while (featureId.next()) {
						insertFeature = "INSERT INTO SetTopBox_Feature VALUES (" + id.getInt(1) + ","
								+ featureId.getInt(1) + ")";
						JdbcDTH.executeDTHQueries(insertFeature);
						System.out.println(insertFeature);
					}
				}

			}
			return true;
		} catch (Exception e) {
			System.err.println("Exception thrown : " + e);
		}
		return false;
	}

	// Remove particular Set Top Box from SetTopBox Table
	public boolean deleteSetTopBox(String name) {

		try {
			String idQuery = "Select setTopBoxId from SetTopBox where STBType='" + name + "'";
			ResultSet id = JdbcDTH.executeDTHQueries(idQuery);
			while (id.next()) {

			    String deleteFeature = "Delete from SETTOPBOX_FEATURE where settopboxId=" + id.getInt(1);
			    
			    JdbcDTH.executeDTHQueries(deleteFeature);
				
				String deleteBoxQuery = "DELETE FROM setTopBox WHERE setTopBoxId=" + id.getInt(1);

				// Create query to remove features for a particular Set Top Box from
				// setTopBox_feature Table
				// String deleteFeaturesQuery = "DELETE FROM setTopBox_feature WHERE
				// setTopBoxId=" + id.getInt(1);

				// Call utility class to connect to the database and receive ResultSet object
				JdbcDTH.executeDTHQueries(deleteBoxQuery);
				// JdbcDTH.executeDTHQueries(deleteFeaturesQuery);
				return true;
			}

		} catch (Exception e) {
			System.out.println("DELETE");
			System.err.println("Exception thrown : " + e);
		}
		return false;
	}
}