package TestData;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class GetTestData {

	String testsetid;
	static CallableStatement callableStatement = null;
	static ResultSet rsActionData;

	public static String getActionData(String varName) throws SQLException {

		String varValue;

		Statement sqlUpdateStatement = Executor.con.createStatement();

		String stepsQry = "SELECT DM.DATANAME,TED.DATAVALUE  FROM ACTION A INNER JOIN ACTIONDATA AD ON AD.ACTIONID=A.ACTIONID INNER JOIN DATAMASTER DM ON DM.DATAID=AD.DATAID "
				+ " INNER JOIN TESTACTIONENVIRONMENT TAE ON TAE.ACTIONID=AD.ACTIONID "
				+ " INNER JOIN TESTENVIRONMENTDATA TED ON TED.DATAID=AD.DATAID AND TED.ENVIRONMENTID=TAE.ENVIRONMENTID  and ted.testid=tae.testid " + " WHERE A.ACTIONID="
				+ ExecuteTestCases.ActionId + " AND TAE.TESTID=" + Executor.testcaseid + " AND TED.ENVIRONMENTID=" + Executor.environmentid;

		ResultSet rsActionData = sqlUpdateStatement.executeQuery(stepsQry);

		varValue = "";

		while (rsActionData.next()) {
			if (rsActionData.getString("DATANAME").equals(varName)) {
				varValue = rsActionData.getString("DATAVALUE");
			}
		}
		rsActionData.close();
		sqlUpdateStatement.close();

		return varValue;

	}

}