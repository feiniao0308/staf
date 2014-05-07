package com.bn.automation.scripts;

import com.bn.automation.staf.anno.AfterMethod;
import com.bn.automation.staf.anno.BeforeMethod;
import com.bn.automation.staf.anno.STAFScript;
import com.bn.automation.staf.anno.Test;
import com.bn.automation.staf.db.DBDriver;
import com.bn.automation.staf.db.OracleDriver;

/**
 * Created by fdkzv on 4/2/14.
 */
@STAFScript
public class db {

    public DBDriver dbDriver;

    @BeforeMethod
    public void setup() {
        dbDriver = new OracleDriver();
        //dbDriver.connect();




    }

    @AfterMethod
    public void tearDown() {


    }

    @Test(id = {4}, enabled = true)
    public void keywordDrivenTest() throws Throwable {
        dbDriver.setData("data/xmlDataFormat.xml");
        //dbDriver.doQuery("SELECT * FROM BN_CORE.DPS_USER where ID = '748'");
        //dbDriver.autoAssert(dbDriver.getData().getDataContainer("db"));
        dbDriver.viewQueryResult("SELECT * FROM BN_CORE.DPS_USER where ID = '748'");




    }

}
