<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">


    <xsl:template match="/">

        <html>
            <head>
              <!--  <title>STAF Log</title>-->
               <!-- <link type="text/css" href="../src/main/resources/log/screen.css"
                      rel="stylesheet"/>-->
                <style>
                    .container {width: 90%; margin: 0 auto;}
                    .datagrid table { border-collapse: collapse; text-align: left; width: 100%; }
                    .datagrid {font: normal 12px/150% Verdana, Arial, Helvetica, sans-serif; background: #fff; overflow: hidden;
                    border: 1px solid #006699; -webkit-border-radius: 3px; -moz-border-radius: 3px; border-radius: 3px; }
                    .datagrid table td, .datagrid table th { padding: 3px 10px; } .datagrid table thead th
                    {background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #006699), color-stop(1, #00557F)
                    );background:-moz-linear-gradient( center top, #006699 5%, #00557F 100%
                    );filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#006699',
                    endColorstr='#00557F');background-color:#006699; color:#FFFFFF; font-size: 12px; font-weight: bold; border-left:
                    1px solid #0070A8; } .datagrid tbody tr:nth-child(even) td, tbody tr.even td {background:#E1EEf4; color:
                    #00557F;} .datagrid table thead th:first-child { border: none; } .datagrid table tbody td { color: #00557F;
                    border-left:
                    1px solid #E1EEF4;font-size: 12px;font-weight: normal; } .datagrid table tbody td:first-child { border-left:
                    none; }.datagrid table tbody tr:last-child td {
                    border-bottom: none; }
                    .datagrid table tfoot td div { border-top: 1px solid #006699;background: #E1EEf4;} .datagrid table tfoot td {
                    padding: 0; font-size: 12px }
                    .datagrid table tfoot td div{ padding: 2px; }.datagrid table tfoot td ul { margin: 0; padding:0; list-style:
                    none; text-align: right;
                    }.datagrid table tfoot li { display: inline; } .datagrid table tfoot li a { text-decoration: none; display:
                    inline-block; padding: 2px 8px; margin: 1px;color: #FFFFFF;border: 1px solid #006699;-webkit-border-radius: 3px;
                    -moz-border-radius: 3px; border-radius: 3px; background:-webkit-gradient( linear, left top, left bottom,
                    color-stop(0.05, #006699), color-stop(1, #00557F) );background:-moz-linear-gradient( center top, #006699 5%,
                    #00557F 100% );filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#006699',
                    endColorstr='#00557F');background-color:#006699; } .datagrid table tfoot ul.active, .datagrid table tfoot ul
                    a:hover { text-decoration: none;border-color: #00557F; color: #FFFFFF; background: none;
                    background-color:#006699;}div.dhtmlx_window_active, div.dhx_modal_cover_dv { position: fixed !important; }
                </style>
            </head>
            <body>
                <div class="container">
                   <!-- <h1>STAF Log - Execution Report</h1>
                    <p>Welcome to the Staflog. This page displays the test case
                        execution results.
                    </p>-->
                    <div class="datagrid">
                    <table border="0" cellspacing="0" cellpadding="0">
                        <thead>
                            <tr>
                                <th class="span-4">Index</th>
                                <th class="span-4">Class Name</th>
                                <th class="span-4">Test Case ID</th>
                                <th class="span-4">Method Name / TestCase Name</th>
                                <th class="span-4">Result</th>
                                <th class="span-4">Execution Time (ms)</th>
                            </tr>
                        </thead>

                        <xsl:for-each select="root/testcase">
                            <tr class="alt">
                                <td>
                                    <xsl:value-of
                                            select="position()"/>
                                </td>
                                <td>
                                    <xsl:value-of
                                            select="class_name"/>
                                </td>
                                <td>
                                    <xsl:value-of select="@id"/>
                                </td>
                                <td>
                                    <xsl:value-of select="method_name"/>
                                </td>
                                <td>
                                    <xsl:value-of
                                            select="result"/>
                                </td>
                                <td>
                                    <xsl:value-of select="time"/>
                                </td>

                            </tr>
                        </xsl:for-each>

                        <!-- <xsl:for-each select="StafLogRoot/testcase"> <tr> <td> <xsl:value-of
                            select="name" /> </td> <td> <xsl:value-of select="time" /> </td> <td> <xsl:value-of
                            select="passcount" /> </td> <td> <xsl:value-of select="failcount" /> </td>
                            <td>90%</td> </tr> </xsl:for-each> -->
                    </table>
                    </div>


                    <!--<table border="0" cellspacing="0" cellpadding="0">
                        <thead>
                            <tr>
                                <th class="span-2">Type</th>
                                <th class="span-10">Message</th>
                            </tr>
                        </thead>

                        <xsl:for-each select="staf:Event">
                            <tr>
                                <td>
                                    <xsl:value-of select="@level"/>
                                </td>
                                <td>
                                    <xsl:value-of select="staf:Message"/>
                                </td>

                            </tr>
                        </xsl:for-each>
                    </table>-->
                </div>
            </body>
        </html>


    </xsl:template>

</xsl:stylesheet>