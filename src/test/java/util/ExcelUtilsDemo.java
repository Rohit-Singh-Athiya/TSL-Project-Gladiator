package util;

public class ExcelUtilsDemo {

	public static void main(String[] args) {
      ExcelUtils  excel = new ExcelUtils("C:\\LTI-Eclipse Workspace\\easeMyTripDemo1\\Excel\\data.xlsx","Sheet1");
      excel.getCellDataString(0, 0);
      excel.getCellDataNumber(1, 3);
	}
}
