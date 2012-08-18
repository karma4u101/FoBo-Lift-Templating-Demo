package code.snippet

import code.lib.DataTable

class DataTablePDemo {
  
  def table = {
    val columns = "Col1" :: "Col2" :: Nil

    // this function returns data to populate table based on parameters passed in
    val fun = (params: DataTable.Params) => {
      val rows = List(("row1_col1", "row1_col2"), ("row2_col1", "row2_col2"))
      val count = 2

      new DataTable.ObjectSource(count, count, rows.map(r =>
        List(("0", r._1),
          ("1", r._2),
          ("DT_RowId", "rowid_" + r._1))))
    }

    DataTable.Table(
      columns, // columns
      fun, // our data provider
      "my-table", // html table id
      List(("bFilter", "false"),("bJQueryUI","true")), // datatables configuration
      ("class", "display")) // set css class for table --- table table-striped table-bordered
  }
}
