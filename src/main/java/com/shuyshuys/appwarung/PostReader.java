package com.shuyshuys.appwarung;

import java.sql.ResultSet;
import java.sql.Statement;

public class PostReader {
    static int idx_count;
    static int idx_max_makanan;
    static int idx_max_minuman;
    static int idx_max_pembeli;

    // private static String line;

    public static void getPostReader(String category) {
        try {
            add.border();

            if (category == "makanan") {

                String count = "SELECT category_barang,COUNT(*) FROM barang WHERE category_barang = 'makanan' GROUP BY category_barang;";
                ResultSet rs = Post.getCon().createStatement().executeQuery(count);
                while (rs.next()) {
                    cMenuCLI.makanan = new cMakanan[rs.getInt(2) + 10];
                    add.idx_max_makanan = rs.getInt(2) + 10;
                }

                String sql = "SELECT * FROM barang WHERE category_barang = '" + category + "';";
                Statement statement = Post.getCon().createStatement();
                ResultSet res = statement.executeQuery(sql);
                while (res.next()) {
                    cMenuCLI.makanan[add.idxMakanan] = new cMakanan(
                            Integer.parseInt(res.getString(1)),
                            res.getString(2),
                            Integer.parseInt(res.getString(3)));
                    cMenuCLI.makanan[add.idxMakanan].ToString();
                    add.idxMakanan++;
                }
            } else if (category == "minuman") {

                String count = "SELECT category_barang,COUNT('minuman') FROM barang WHERE category_barang = 'minuman' GROUP BY category_barang;";
                ResultSet rs = Post.getCon().createStatement().executeQuery(count);
                while (rs.next()) {
                    cMenuCLI.minuman = new cMinuman[rs.getInt(2) + 10];
                    add.idx_max_minuman = rs.getInt(2) + 10;
                }

                String sql = "SELECT * FROM barang WHERE category_barang = '" + category + "';";
                Statement stmt = Post.getCon().createStatement();
                ResultSet res = stmt.executeQuery(sql);
                while (res.next()) {
                    cMenuCLI.minuman[add.idxMinuman] = new cMinuman(
                            res.getInt(1),
                            res.getString(2),
                            res.getInt(3));
                    cMenuCLI.minuman[add.idxMinuman].ToString();
                    add.idxMinuman++;
                }
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
