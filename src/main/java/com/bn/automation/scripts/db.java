package com.bn.automation.scripts;

import com.bn.automation.staf.anno.AfterMethod;
import com.bn.automation.staf.anno.BeforeMethod;
import com.bn.automation.staf.anno.STAFScript;
import com.bn.automation.staf.anno.Test;
import com.bn.automation.staf.db.OracleDriver;

import java.sql.SQLException;

/**
 * Created by fdkzv on 4/2/14.
 */
@STAFScript
public class db {

    public OracleDriver oracleDriver;

    @BeforeMethod
    public void setup() {
        try {
        oracleDriver = new OracleDriver();
        //dbDriver.connect();
        oracleDriver.connect("qwecddb","1521","scppq","CA13","CA13");
        oracleDriver.doQuery("SELECT to_char(sysdate,'MM-DD-YYYY HH24:MI:SS'),  to_char(scheduled_dttm,'MM-DD-YYYY HH24:MI:SS'), ome.is_executed, ome.* FROM ca13.OM_SCHED_EVENT ome WHERE EVENT_OBJECTS LIKE '%Settlement%' ORDER BY scheduled_dttm desc");
        String r = null;
            while(oracleDriver.getResultSet().next()){
                r = oracleDriver.getResultSet().getObject(5).toString();
            }


        System.out.println("r = " + r);
        oracleDriver.viewQueryResult("UPDATE CA13.OM_SCHED_EVENT SET SCHEDULED_DTTM=SYSDATE,IS_EXECUTED=0  WHERE EVENT_ID=" + r);
        oracleDriver.viewQueryResult("COMMIT");
        Thread.sleep(15000);

        oracleDriver.viewQueryResult("SELECT * FROM ca13.A_BATCH_PROCESSING ORDER BY CREATED_DTTM DESC");
        String status1 = oracleDriver.getResultSet().getObject(5).toString();
        System.out.println("status = " + status1);
        oracleDriver.viewQueryResult("SELECT to_char(sysdate,'MM-DD-YYYY HH24:MI:SS'),  to_char(scheduled_dttm,'MM-DD-YYYY HH24:MI:SS'), ome.is_executed, ome.* FROM ca13.OM_SCHED_EVENT ome WHERE EVENT_OBJECTS LIKE '%recordStatus=3%' ORDER BY scheduled_dttm desc");
        String batchID = oracleDriver.getResultSet().getObject(5).toString();
        oracleDriver.viewQueryResult("UPDATE CA13.OM_SCHED_EVENT SET SCHEDULED_DTTM=SYSDATE,IS_EXECUTED=0  WHERE EVENT_ID="+batchID);
        oracleDriver.viewQueryResult("COMMIT");
        Thread.sleep(15000);
        oracleDriver.viewQueryResult("SELECT * FROM ca13.A_BATCH_PROCESSING ORDER BY CREATED_DTTM DESC");
        String status2 = oracleDriver.getResultSet().getObject(5).toString();
        System.out.println("status2 = " + status2);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    @AfterMethod
    public void tearDown() {


    }

    @Test(id = {4}, enabled = true)
    public void keywordDrivenTest() throws Throwable {
       /* dbDriver.setData("data/xmlDataFormat.xml");
        //dbDriver.doQuery("SELECT * FROM BN_CORE.DPS_USER where ID = '748'");
        //dbDriver.autoAssert(dbDriver.getData().getDataContainer("db"));
        dbDriver.viewQueryResult("SELECT * FROM BN_CORE.DPS_USER where ID = '748'");*/




    }

}
