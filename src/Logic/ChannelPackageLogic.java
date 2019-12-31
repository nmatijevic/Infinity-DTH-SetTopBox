package Logic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import entities.ChannelPackage;
import entities.SetTopBox;
import utility.JdbcDTH;

public class ChannelPackageLogic {

	public List<ChannelPackage> view() {

		// Create SetTopBoxModel Object
		List<ChannelPackage> pkgList = new ArrayList<>();

		try {

			// Create query to get information about all Set Top Boxes
			String viewQuery = "SELECT * FROM Package";
			ChannelPackage channelPkg;
			// Call utility class to connect to the database and receive ResultSet object
			ResultSet channelPackageInfo = JdbcDTH.executeDTHQueries(viewQuery);
			String categoriesQuery;
			ResultSet categoryId;
			String categoryQuery;
			ResultSet category;
			List<String> pkgCategoryList;
			while (channelPackageInfo.next()) {

				channelPkg = new ChannelPackage();
				pkgCategoryList = new ArrayList<>();
				channelPkg.setPkgName(channelPackageInfo.getString(2));
				channelPkg.setPkgChargeType(channelPackageInfo.getString(3));
				channelPkg.setPkgTransmissionType(channelPackageInfo.getString(4));
				channelPkg.setPkgCost(channelPackageInfo.getInt(5));
				System.out.println("Hello");
				System.out.println(channelPackageInfo.getDate(6));
				channelPkg.setPkgFromDate(channelPackageInfo.getDate(6));
				channelPkg.setPkgToDate(channelPackageInfo.getDate(7));
				channelPkg.setPkgByDefault(channelPackageInfo.getString(8));

				categoriesQuery = "Select pkgCategoryId from Package_PackageCategory where PkgId="
						+ channelPackageInfo.getInt(1);
				System.out.println(categoriesQuery);
				categoryId = JdbcDTH.executeDTHQueries(categoriesQuery);
				while (categoryId.next()) {
					categoryQuery = "Select pkgCategoryName from PackageCategory where pkgCategoryId="
							+ categoryId.getInt(1);
					System.out.println(categoryQuery);
					category = JdbcDTH.executeDTHQueries(categoryQuery);
					while (category.next()) {
						pkgCategoryList.add(category.getString(1));
					}
				}

				channelPkg.setPkgCategory(pkgCategoryList);

				pkgList.add(channelPkg);

			}
			// Return a list of SetTopBoxModel Objects
			return pkgList;
		} catch (Exception e) {
			System.err.println("Exception thrown : " + e);
		}
		// Return empty list of SetTopBoxModel Objects
		return pkgList;
	}

	public boolean addPkg(String pkgName, String pkgChargeType, String pkgTransmissionType, int pkgCost,
			Date pkgFromDate, Date pkgToDate, String pkgByDefault, List<String> categories) {

		try {
			ResultSet pkgId;
			ResultSet categoryId;
			String categoryIdQuery;
			String addCategory;
			// Create query to insert new Set Top Box into SetTopBox Table
			String addPkg = "INSERT INTO Package VALUES (package_seq.nextval," + "'" + pkgName + "'" + "," + "'"
					+ pkgChargeType + "'" + "," + "'" + pkgTransmissionType + "'" + "," + pkgCost + "," + "TO_DATE("
					+ "'" + pkgFromDate + "'" + "," + "'" + "yyyy-mm-dd" + "'" + ")" + "," + "TO_DATE("
					+ "'" + pkgToDate + "'" + "," + "'" + "yyyy-mm-dd" + "'" + ")" + "," + "'" + pkgByDefault + "'" + ")";
			System.out.println(addPkg);

			// Call utility class to connect to the database and receive ResultSet object
			ResultSet STBAdded = JdbcDTH.executeDTHQueries(addPkg);
			String pkgIdQuery = "SELECT pkgId FROM Package WHERE pkgName=" + "'" + pkgName + "'";
			System.out.println(pkgIdQuery);
			pkgId = JdbcDTH.executeDTHQueries(pkgIdQuery);
			while (pkgId.next()) {
				for (int i = 0; i < categories.size(); i++) {

					categoryIdQuery = "SELECT pkgCategoryId FROM PackageCategory WHERE pkgCategoryName="
							+ "'" + categories.get(i) + "'";
					System.out.println(categoryIdQuery);
					categoryId = JdbcDTH.executeDTHQueries(categoryIdQuery);
					// Create query to insert features for new Set Top Box into settopbox_feature
					// Table
					while (categoryId.next()) {
						addCategory = "INSERT INTO Package_PackageCategory VALUES (" + pkgId.getInt(1) + ","
								+ categoryId.getInt(1) + ")";
						System.out.println(addCategory);
						// Call utility class to connect to the database and receive ResultSet object
						JdbcDTH.executeDTHQueries(addCategory);
					}
				}
			}
			return true;

		} catch (Exception e) {
			System.err.println("Exception thrown : " + e);
		}
		return false;

	}

	public boolean updateChannelPackage(String oldPkgName, String newPkgName, String newPkgChargeType,
			String newPkgTransmissionType, int newPkgCost, Date newPkgFromDate, Date newPkgToDate,
			String newPkgByDefault,List<String> categories) {

		try {

			// Get the id of the SetTopBox we want to update
			String pkgId = "SELECT pkgId FROM Package WHERE pkgName=" + "'" + oldPkgName + "'";
			ResultSet id = JdbcDTH.executeDTHQueries(pkgId);
			String deleteCategory;
			String categoryIdQuery;
			ResultSet categoryId;
			String insertCategory;
			while (id.next()) {
				// Create query to update information about particular Set Top Box
				String updateQuery = "UPDATE Package Set pkgName=" + "'" + newPkgName + "'" + "," + "pkgChargeType="
						+ "'" + newPkgChargeType + "'" + "," + "pkgTransmissionType=" + "'" + newPkgTransmissionType
						+ "'" + "," + "pkgCost=" + newPkgCost + "," + "pkgFromDate=" + "TO_DATE("
						+ "'" + newPkgFromDate + "'" + "," + "'" + "yyyy-mm-dd" + "'" + ")"+ ","
						+ "pkgToDate=" + "TO_DATE("
						+ "'" + newPkgToDate + "'" + "," + "'" + "yyyy-mm-dd" + "'" + ")" + "," + "pkgByDefault=" + "'" + newPkgByDefault + "'"
						+ "where pkgId=" + id.getInt(1);
				System.out.println(updateQuery);

				// Call utility class to connect to the database and receive ResultSet object
				JdbcDTH.executeDTHQueries(updateQuery);
				System.out.println(categories);
				deleteCategory = "Delete from Package_PackageCategory where pkgId=" + id.getInt(1);
				System.out.println(deleteCategory);
				JdbcDTH.executeDTHQueries(deleteCategory);
				for (int i = 0; i < categories.size(); i++) {
					categoryIdQuery = "SELECT pkgCategoryId FROM PackageCategory WHERE pkgCategoryName=" + "'" + categories.get(i) + "'";
					System.out.println(categoryIdQuery);
					categoryId = JdbcDTH.executeDTHQueries(categoryIdQuery);
					while (categoryId.next()) {
						insertCategory = "INSERT INTO Package_PackageCategory VALUES (" + id.getInt(1) + ","
								+ categoryId.getInt(1) + ")";
						System.out.println(insertCategory);
						JdbcDTH.executeDTHQueries(insertCategory);
						System.out.println(insertCategory);
					}
				}
			}
			return true;
		} catch (Exception e) {
			System.err.println("Exception thrown : " + e);
		}
		return false;

	}

	public boolean deleteChannelPackage(String channelPackageName) {

		try {
			String idQuery = "Select pkgId from Package where pkgName='" + channelPackageName + "'";
			ResultSet id = JdbcDTH.executeDTHQueries(idQuery);
			while (id.next()) {

			    String deleteCategory = "Delete from Package_PackageCategory where pkgId=" + id.getInt(1);
			    
			    JdbcDTH.executeDTHQueries(deleteCategory);
				
				String deletePackageQuery = "DELETE FROM Package WHERE pkgId=" + id.getInt(1);

				// Create query to remove features for a particular Set Top Box from
				// setTopBox_feature Table
				// String deleteFeaturesQuery = "DELETE FROM setTopBox_feature WHERE
				// setTopBoxId=" + id.getInt(1);

				// Call utility class to connect to the database and receive ResultSet object
				JdbcDTH.executeDTHQueries(deletePackageQuery);
				// JdbcDTH.executeDTHQueries(deleteFeaturesQuery);
			}
			return true;
		} catch (Exception e) {
			System.err.println("Exception thrown : " + e);
		}
		return false;
	}
}
