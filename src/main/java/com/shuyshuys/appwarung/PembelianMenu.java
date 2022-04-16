package com.shuyshuys.appwarung;

// import javax.swing.table.DefaultTableModel;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

// import com.shuyshuys.appwarung.koneksi;
// import java.sql.*;
/**
 * @author shuyshuys
 */
public class PembelianMenu extends javax.swing.JFrame {

    static int total = 0;

    public void getTableBarang() {
        DefaultTableModel dataModel = new DefaultTableModel();
        dataModel.addColumn("ID");
        dataModel.addColumn("Nama");
        dataModel.addColumn("Harga");
        dataModel.addColumn("Kategori");

        try {
            String sql = "SELECT * FROM barang ORDER BY id_barang ASC";
            Statement statement = Post.getCon().createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                dataModel.addRow(new Object[] { rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4) });
                jTabelBarang.setModel(dataModel);
            }
            statement.close();
            rs.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Update Tabel Gagal!", "", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void getTableMember() {
        DefaultTableModel dataModel = new DefaultTableModel();
        dataModel.addColumn("ID");
        dataModel.addColumn("Nama");
        dataModel.addColumn("Alamat");

        try {
            String sql = "SELECT * FROM member ORDER BY id ASC";
            Statement statement = Post.getCon().createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                dataModel.addRow(new Object[] { rs.getString(1),
                        rs.getString(2),
                        rs.getString(3) });
                jTableMember.setModel(dataModel);
            }
            statement.close();
            rs.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Update Tabel Gagal!", "", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void getTablePembelian() {
        DefaultTableModel dataModel = new DefaultTableModel();
        dataModel.addColumn("ID Transaksi");
        dataModel.addColumn("Nama");
        dataModel.addColumn("Harga");
        dataModel.addColumn("Jumlah");
        dataModel.addColumn("Total");

        try {
            String sql = "SELECT * FROM pembelian ORDER BY id_transaksi ASC";
            Statement statement = Post.getCon().createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                dataModel.addRow(new Object[] { rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5) });
                jTablePembelian.setModel(dataModel);
            }
            statement.close();
            rs.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Update Tabel Gagal!", "", JOptionPane.ERROR_MESSAGE);
        }

    }

    // static String getID;

    public void getTableDetailPembelian(String getID) {
        DefaultTableModel dataModel = new DefaultTableModel();
        dataModel.addColumn("ID Transaksi");
        dataModel.addColumn("Barang");
        dataModel.addColumn("Harga");
        dataModel.addColumn("Jumlah");
        dataModel.addColumn("Subtotal");

        try {
            String sql = "SELECT * FROM detail_pembelian WHERE id_transaksi = '" + getID + "';";
            Statement statement = Post.getCon().createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                dataModel.addRow(new Object[] { rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5) });
                jTableDetailPembelian.setModel(dataModel);
            }
            statement.close();
            rs.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Update Tabel Gagal!", "", JOptionPane.ERROR_MESSAGE);
        }

    }

    // public void getTable() {
    // DefaultTableModel model = new DefaultTableModel();
    // model.addColumn("ID");
    // model.addColumn("Nama");
    // model.addColumn("Harga");
    // model.addColumn("Stok");
    // model.addColumn("Kategori");
    // model.addColumn("Keterangan");
    //
    // try {
    // String sql = "select * from mhs";
    // java.sql.Connection conn = (Connection) config.configDB();
    // java.sql.Statement stm = conn.createStatement();
    // java.sql.ResultSet rs = stm.executeQuery(sql);
    //
    // while (rs.next()) {
    // model.addRow(new Object[] { rs.getString(1),
    // rs.getString(2),
    // rs.getString(3),
    // rs.getString(4),
    // rs.getString(5),
    // rs.getString(6) });
    // }
    // } catch (Exception e) {
    // // handle exception
    // }
    // }
    /**
     * Creates new form BarangMenu
     */
    public PembelianMenu() {
        add.cls();
        initComponents();
        getTableBarang();
        getTableMember();
        getTablePembelian();
        // Login lgn = new Login();
        // jLabelUserLogin.setText(lgn.getUser());
        // System.out.println(lgn.getUser());
    }

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int locX = ((screenSize.width - 800) / 2);
    int locY = ((screenSize.height - 700) / 2);

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePembelian = new javax.swing.JTable();
        jLabelIdPembelian = new javax.swing.JLabel();
        jTextFieldIdPembelian = new javax.swing.JTextField();
        jLabelNamaPembelian = new javax.swing.JLabel();
        jTextFieldNamaPembelian = new javax.swing.JTextField();
        jLabelHargaPembelian = new javax.swing.JLabel();
        jTextFieldHargaPembelian = new javax.swing.JTextField();
        jLabelKategoriPembelian = new javax.swing.JLabel();
        jTextFieldKategoriPembelian = new javax.swing.JTextField();
        jLabelPembelianMenu = new javax.swing.JLabel();
        jLabelSortBY = new javax.swing.JLabel();
        jComboBoxSort = new javax.swing.JComboBox<>();
        jComboBoxSort2 = new javax.swing.JComboBox<>();
        jLabelPembeli = new javax.swing.JLabel();
        jTextFieldPembeli = new javax.swing.JTextField();
        jLabelQuantityPembelian = new javax.swing.JLabel();
        jTextFieldQuantityPembelian = new javax.swing.JTextField();
        jButtonTambahPembelian = new javax.swing.JButton();
        jLabelSubtotal = new javax.swing.JLabel();
        jTextFieldSubtotal = new javax.swing.JTextField();
        jLabelTunai = new javax.swing.JLabel();
        jTextFieldTunai = new javax.swing.JTextField();
        jButtonRegisterMember = new javax.swing.JButton();
        jButtonSimpanTransaksi = new javax.swing.JButton();
        jButtonHapusTransaksi = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTabelBarang = new javax.swing.JTable();
        jButtonBack = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableMember = new javax.swing.JTable();
        jButtonApplySort = new javax.swing.JButton();
        jLabelTableMember = new javax.swing.JLabel();
        jLabelTableBarang = new javax.swing.JLabel();
        jTextFieldSearchBarang = new javax.swing.JTextField();
        jButtonSearchBarang = new javax.swing.JButton();
        jButtonSearchMember = new javax.swing.JButton();
        jTextFieldSearchMember = new javax.swing.JTextField();
        jLabelTotal = new javax.swing.JLabel();
        jTextFieldTotal = new javax.swing.JTextField();
        jTextFieldDiskon = new javax.swing.JTextField();
        jLabelDiskon = new javax.swing.JLabel();
        jLabelUserLogin = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableDetailPembelian = new javax.swing.JTable();
        jLabelKembali = new javax.swing.JLabel();
        jTextFieldKembali = new javax.swing.JTextField();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Pembelian");
        setLocation(locX, locY);
        setName("frameMenuPembelian"); // NOI18N

        jTablePembelian.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null, null, null, null, null },
                        { null, null, null, null, null, null },
                        { null, null, null, null, null, null },
                        { null, null, null, null, null, null }
                },
                new String[] {
                        "ID Transaksi", "Tgl Transaksi", "Pembeli", "Total Harga", "Bayar", "Kembali"
                }) {
            boolean[] canEdit = new boolean[] {
                    false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jTablePembelian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePembelianMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTablePembelian);

        jLabelIdPembelian.setText("ID");

        jTextFieldIdPembelian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIdPembelianActionPerformed(evt);
            }
        });

        jLabelNamaPembelian.setText("Nama");

        jLabelHargaPembelian.setText("Harga");

        jLabelKategoriPembelian.setText("Kategori");

        jLabelPembelianMenu.setFont(new java.awt.Font("Fira Code Retina", 0, 24)); // NOI18N
        jLabelPembelianMenu.setText("MENU PEMBELIAN");

        jLabelSortBY.setText("Urutkan:");

        jComboBoxSort.setModel(new javax.swing.DefaultComboBoxModel<>(
                new String[] { "Tabel Transaksi", "Tabel Detail Transaksi", "Tabel Barang", "Tabel Member" }));
        jComboBoxSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSortActionPerformed(evt);
            }
        });

        jComboBoxSort2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ASC", "DES" }));
        jComboBoxSort2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSort2ActionPerformed(evt);
            }
        });

        jLabelPembeli.setText("Pembeli");

        jLabelQuantityPembelian.setText("Jumlah");

        jButtonTambahPembelian.setText("Tambah Barang");
        jButtonTambahPembelian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTambahPembelianActionPerformed(evt);
            }
        });

        jLabelSubtotal.setText("Subtotal");

        jTextFieldSubtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSubtotalActionPerformed(evt);
            }
        });

        jLabelTunai.setText("Tunai");

        jButtonRegisterMember.setText("Register Member");
        jButtonRegisterMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegisterMemberActionPerformed(evt);
            }
        });

        jButtonSimpanTransaksi.setText("Simpan Transaksi");
        jButtonSimpanTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSimpanTransaksiActionPerformed(evt);
            }
        });

        jButtonHapusTransaksi.setText("Hapus Transaksi");
        jButtonHapusTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHapusTransaksiActionPerformed(evt);
            }
        });

        jScrollPane2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jTabelBarang.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null, null, null }
                },
                new String[] {
                        "ID Barang", "Nama", "Harga", "Kategori"
                }));
        jTabelBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelBarangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTabelBarang);

        jButtonBack.setText("Back");
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });

        jTableMember.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null }
                },
                new String[] {
                        "ID Member", "Nama Member"
                }) {
            boolean[] canEdit = new boolean[] {
                    false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jTableMember.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMemberMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableMember);

        jButtonApplySort.setText("Apply");

        jLabelTableMember.setFont(new java.awt.Font("Fira Code Retina", 0, 18)); // NOI18N
        jLabelTableMember.setText("Member");

        jLabelTableBarang.setFont(new java.awt.Font("Fira Code Retina", 0, 18)); // NOI18N
        jLabelTableBarang.setText("Barang");

        jButtonSearchBarang.setText("Search");
        jButtonSearchBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchBarangActionPerformed(evt);
            }
        });

        jButtonSearchMember.setText("Search");

        jLabelTotal.setText("Total");

        jLabelDiskon.setText("Diskon");

        jLabelUserLogin.setText("User Login");

        jTableDetailPembelian.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null, null, null, null },
                        { null, null, null, null, null },
                        { null, null, null, null, null },
                        { null, null, null, null, null }
                },
                new String[] {
                        "ID Transaksi", "Barang", "Harga", "Jumlah", "Subtotal"
                }) {
            boolean[] canEdit = new boolean[] {
                    false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane5.setViewportView(jTableDetailPembelian);

        jLabelKembali.setText("Kembali");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout
                                                .createSequentialGroup()
                                                .addComponent(jLabelSortBY)
                                                .addGap(5, 5, 5)
                                                .addComponent(jComboBoxSort, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(33, 33, 33)
                                                                .addComponent(jLabelPembelianMenu)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE)
                                                                .addComponent(jLabelUserLogin))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jComboBoxSort2,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jButtonApplySort)
                                                                .addGap(0, 0, Short.MAX_VALUE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButtonBack))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jScrollPane3,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 250,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(
                                                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                                                        false)
                                                                                        .addGroup(layout
                                                                                                .createSequentialGroup()
                                                                                                .addGroup(layout
                                                                                                        .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                        .addGroup(layout
                                                                                                                .createParallelGroup(
                                                                                                                        javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                        false)
                                                                                                                .addComponent(
                                                                                                                        jLabelDiskon,
                                                                                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                        Short.MAX_VALUE)
                                                                                                                .addComponent(
                                                                                                                        jLabelPembeli,
                                                                                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                        50,
                                                                                                                        Short.MAX_VALUE))
                                                                                                        .addComponent(
                                                                                                                jLabelTotal,
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                50,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addGap(6, 6, 6)
                                                                                                .addGroup(layout
                                                                                                        .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                        .addComponent(
                                                                                                                jTextFieldDiskon,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                110,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                        .addComponent(
                                                                                                                jTextFieldPembeli,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                110,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                        .addComponent(
                                                                                                                jTextFieldTotal,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                110,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addPreferredGap(
                                                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                                                                        .addGroup(
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                layout.createSequentialGroup()
                                                                                                        .addComponent(
                                                                                                                jLabelKembali)
                                                                                                        .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                        .addComponent(
                                                                                                                jTextFieldKembali,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                111,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                        .addGap(6, 6,
                                                                                                                6)))
                                                                                .addGroup(layout.createParallelGroup(
                                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addGroup(layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(0, 0,
                                                                                                        Short.MAX_VALUE)
                                                                                                .addComponent(
                                                                                                        jTextFieldHargaPembelian,
                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                        200,
                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                        .addGroup(layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(
                                                                                                        jButtonHapusTransaksi)
                                                                                                .addGap(0, 0,
                                                                                                        Short.MAX_VALUE))))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(jLabelTunai,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        50,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(
                                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jTextFieldTunai,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        110,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(
                                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jButtonSimpanTransaksi,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        115,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(
                                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        Short.MAX_VALUE)
                                                                                .addGroup(layout.createParallelGroup(
                                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addGroup(
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                layout.createParallelGroup(
                                                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                        .addComponent(
                                                                                                                jTextFieldKategoriPembelian,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                200,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                        .addGroup(layout
                                                                                                                .createParallelGroup(
                                                                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(
                                                                                                                        jTextFieldSubtotal,
                                                                                                                        javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                        180,
                                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(
                                                                                                                        jTextFieldQuantityPembelian,
                                                                                                                        javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                        200,
                                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                        .addComponent(
                                                                                                jButtonTambahPembelian,
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                115,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(6, 6, 6)
                                                                                .addComponent(jLabelTableBarang))
                                                                        .addGroup(
                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                layout.createSequentialGroup()
                                                                                        .addComponent(jLabelTableMember)
                                                                                        .addGap(11, 11, 11)
                                                                                        .addComponent(
                                                                                                jTextFieldSearchMember,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                90,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                        .addComponent(
                                                                                                jButtonSearchMember)
                                                                                        .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                        .addComponent(
                                                                                                jButtonRegisterMember,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                149,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(
                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                layout.createSequentialGroup()
                                                                                        .addComponent(
                                                                                                jTextFieldSearchBarang,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                100,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                        .addComponent(
                                                                                                jButtonSearchBarang))
                                                                        .addComponent(jScrollPane2,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                0, Short.MAX_VALUE)
                                                                        .addComponent(jScrollPane1,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                422, Short.MAX_VALUE))
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jScrollPane5,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                346, Short.MAX_VALUE)
                                                                        .addGroup(
                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                layout.createSequentialGroup()
                                                                                        .addGap(0, 0, Short.MAX_VALUE)
                                                                                        .addGroup(layout
                                                                                                .createParallelGroup(
                                                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addComponent(
                                                                                                        jTextFieldNamaPembelian,
                                                                                                        javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                        200,
                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(
                                                                                                        jTextFieldIdPembelian,
                                                                                                        javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                        200,
                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(32, 32, 32)
                                                                                .addGroup(layout.createParallelGroup(
                                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(
                                                                                                jLabelQuantityPembelian,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                92,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addGroup(layout
                                                                                                .createParallelGroup(
                                                                                                        javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                .addComponent(
                                                                                                        jLabelIdPembelian,
                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                        60,
                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(
                                                                                                        jLabelNamaPembelian,
                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                        60,
                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(
                                                                                                        jLabelHargaPembelian,
                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                        60,
                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(
                                                                                                        jLabelKategoriPembelian,
                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                        60,
                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                        .addComponent(jLabelSubtotal,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                60,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGap(0, 0, Short.MAX_VALUE)))))
                                                .addGap(13, 13, 13)))
                                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelPembelianMenu)
                                        .addComponent(jButtonBack)
                                        .addComponent(jLabelUserLogin))
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelSortBY)
                                        .addComponent(jComboBoxSort, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonApplySort)
                                        .addComponent(jComboBoxSort2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 361,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jTextFieldIdPembelian,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabelIdPembelian))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jTextFieldNamaPembelian,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabelNamaPembelian))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                                .createSequentialGroup()
                                                                .addComponent(jTextFieldHargaPembelian,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jTextFieldKategoriPembelian,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabelKategoriPembelian))
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jTextFieldQuantityPembelian,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabelQuantityPembelian))
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jTextFieldSubtotal,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabelSubtotal))
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jButtonSimpanTransaksi)
                                                                .addGap(7, 7, 7)
                                                                .addComponent(jButtonHapusTransaksi)
                                                                .addContainerGap())
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                layout.createSequentialGroup()
                                                                        .addComponent(jButtonTambahPembelian)
                                                                        .addGap(28, 28, 28))))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                .createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jScrollPane1,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 176,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(6, 6, 6)
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jTextFieldSearchBarang,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jButtonSearchBarang)
                                                                        .addComponent(jLabelTableBarang))
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jScrollPane2,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 187,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jLabelTableMember)
                                                                        .addComponent(jButtonSearchMember)
                                                                        .addComponent(jTextFieldSearchMember,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jButtonRegisterMember))
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(
                                                                                        javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                        .addComponent(jLabelPembeli)
                                                                                        .addComponent(jTextFieldPembeli,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addPreferredGap(
                                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addGroup(layout.createParallelGroup(
                                                                                        javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                        .addComponent(jTextFieldDiskon,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(jLabelDiskon))
                                                                                .addPreferredGap(
                                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addGroup(layout.createParallelGroup(
                                                                                        javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                        .addComponent(jTextFieldTotal,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(jLabelTotal))
                                                                                .addPreferredGap(
                                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addGroup(layout.createParallelGroup(
                                                                                        javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                        .addComponent(jTextFieldTunai,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(jLabelTunai))
                                                                                .addPreferredGap(
                                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addGroup(layout.createParallelGroup(
                                                                                        javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                        .addComponent(jTextFieldKembali,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(jLabelKembali)))
                                                                        .addComponent(jScrollPane3,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                146,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(427, 427, 427)
                                                                .addComponent(jLabelHargaPembelian)))
                                                .addGap(13, 13, 13)))));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableMemberMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jTableMemberMouseClicked
        DefaultTableModel model = (DefaultTableModel) jTableMember.getModel();
        int selectedRowIndex = jTableMember.getSelectedRow();
        jTextFieldPembeli.setText(model.getValueAt(selectedRowIndex, 1).toString());
        // jTextFieldNamaPembelian.setText(model.getValueAt(selectedRowIndex,
        // 1).toString());
        // jTextFieldHargaPembelian.setText(model.getValueAt(selectedRowIndex,
        // 2).toString());
        // // jTextFieldStokHapus.setText(model.getValueAt(selectedRowIndex,
        // // 3).toString());
        // jTextFieldKategoriPembelian.setText(model.getValueAt(selectedRowIndex,
        // 3).toString());
    }// GEN-LAST:event_jTableMemberMouseClicked

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonBackActionPerformed
        dispose();
        MasterMenu.launchApp();
    }// GEN-LAST:event_jButtonBackActionPerformed

    private void jButtonSimpanTransaksiActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonSimpanTransaksiActionPerformed
        // String total = jTextFieldQuantityPembelian.getText();
        String pembayaran = jTextFieldTunai.getText();
        System.out.println("pembayaran" + pembayaran);
        int kembalian = Integer.parseInt(pembayaran) - total;
        System.out.println("Kembalian : " + kembalian);
        String kembali = Integer.toString(kembalian);
        String tgl = add.getDateTime();
        String pembeli = jTextFieldPembeli.getText();
        String totalString = jTextFieldTotal.getText();
        try {
            String sql = "INSERT INTO pembelian (id_transaksi, tgl_transaksi, pembeli, total, bayar, kembali) VALUES (nextval('pembelian_seq'), '"
                    + tgl + "', '"
                    + pembeli + "', '"
                    + totalString + "', '"
                    + pembayaran + "', '"
                    + kembali + "')";
            Statement statement = Post.getCon().createStatement();
            // statement.setString(1, "nextval('pembelian_seq')");
            // statement.setString(2, add.getDateTime());
            // statement.setString(3, jTextFieldQuantityPembelian.getText());
            // statement.setString(4, jTextFieldTotal.getText());
            // statement.setString(5, jTextFieldTunai.getText());
            // statement.setString(6, kembali);
            statement.executeUpdate(sql);
            statement.close();
            jTextFieldIdPembelian.setText("");
            jTextFieldNamaPembelian.setText("");
            jTextFieldHargaPembelian.setText("");
            jTextFieldKategoriPembelian.setText("");
            jTextFieldPembeli.setText("");
            total = 0;
            getTablePembelian();
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getErrorCode());
            JOptionPane.showMessageDialog(null, e.getNextException());
            JOptionPane.showMessageDialog(null, e.getSQLState());
            JOptionPane.showMessageDialog(null, "Data gagal disimpan" + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }// GEN-LAST:event_jButtonSimpanTransaksiActionPerformed

    private void jButtonRegisterMemberActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonRegisterMemberActionPerformed
        if (jTextFieldPembeli.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nama Pembeli tidak boleh kosong!", "Error",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            String alamat = JOptionPane.showInputDialog("Masukkan Alamat Member");
            try {
                String sql = "INSERT INTO member (id, nama, alamat) VALUES (nextval('member_seq'), '"
                        + jTextFieldPembeli.getText() + "', '" + alamat + "')";
                Statement stmt = Post.getCon().createStatement();
                stmt.executeUpdate(sql);
                stmt.close();
                getTableMember();
                // java.sql.Connection conn = (Connection)Koneksi.configDB();
                // java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                // pstm.execute();
                JOptionPane.showMessageDialog(null, "Member Berhasil Ditambahkan");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Member Gagal Ditambahkan" + e.getStackTrace(), "Error",
                        JOptionPane.ERROR_MESSAGE);
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }// GEN-LAST:event_jButtonRegisterMemberActionPerformed

    private void jTablePembelianMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jTablePembelianMouseClicked

        DefaultTableModel model = (DefaultTableModel) jTablePembelian.getModel();
        int selectedRowIndex = jTablePembelian.getSelectedRow();
        // String getID = model.getValueAt(selectedRowIndex, 0).toString();
        getTableDetailPembelian(model.getValueAt(selectedRowIndex, 0).toString());
    }// GEN-LAST:event_jTablePembelianMouseClicked

    private void jTabelBarangMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jTabelBarangMouseClicked
        DefaultTableModel model = (DefaultTableModel) jTabelBarang.getModel();
        int selectedRowIndex = jTabelBarang.getSelectedRow();
        // jTextFieldIdPembelian.setText(model.getValueAt(selectedRowIndex,
        // 0).toString());
        jTextFieldNamaPembelian.setText(model.getValueAt(selectedRowIndex, 1).toString());
        jTextFieldHargaPembelian.setText(model.getValueAt(selectedRowIndex, 2).toString());
        // jTextFieldStokHapus.setText(model.getValueAt(selectedRowIndex,
        // 3).toString());
        jTextFieldKategoriPembelian.setText(model.getValueAt(selectedRowIndex, 3).toString());
    }// GEN-LAST:event_jTabelBarangMouseClicked

    private void jComboBoxSort2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jComboBoxSort2ActionPerformed
    }// GEN-LAST:event_jComboBoxSort2ActionPerformed

    protected void jButtonHapusTransaksiActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void jButtonSearchBarangActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonSearchBarangActionPerformed
        // add your handling code here:
    }// GEN-LAST:event_jButtonSearchBarangActionPerformed

    private void jButtonTambahPembelianActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonTambahPembelianActionPerformed
        String nama_pembeli = jTextFieldPembeli.getText();
        // String id_barang = jTextFieldIdPembelian.getText();
        String id_transaksi = jTextFieldIdPembelian.getText();
        String nama_barang = jTextFieldNamaPembelian.getText();
        String harga_barang = jTextFieldHargaPembelian.getText();
        String jumlah_barang = jTextFieldQuantityPembelian.getText();
        // String totalString = jTextFieldTotal.getText();
        // String jumlah_barang = Integer.toString(sisaStok);

        int sub = Integer.parseInt(harga_barang) * Integer.parseInt(jumlah_barang);
        String subtotal = Integer.toString(sub);
        System.out.println("subtotal: " + subtotal);
        jTextFieldSubtotal.setText(subtotal);

        total = total + sub;
        System.out.println("total: " + total);
        jTextFieldTotal.setText(Integer.toString(total));

        if (id_transaksi.equals("") ||
                nama_barang.equals("") ||
                harga_barang.equals("") ||
                jumlah_barang.equals("") ||
                subtotal.equals("")) {
            JOptionPane.showMessageDialog(null, "Data tidak boleh kosong");
        } else {
            // TODO: pengecekan sudah member apa belum untuk dapat diskon
            // TODO: pengecekan kalau bayarnya kurang dari total harga
            try {
                String sql = "INSERT INTO detail_pembelian (id_transaksi, barang, harga, jumlah, subtotal) VALUES ('"
                        + id_transaksi + "', '"
                        + nama_barang + "', '"
                        + harga_barang + "', '"
                        + jumlah_barang + "', '"
                        + subtotal + "');";

                Statement stmt = Post.getCon().createStatement();
                stmt.executeUpdate(sql);
                stmt.close();

                JOptionPane.showMessageDialog(null, "Pembelian Berhasil!", "",
                        JOptionPane.INFORMATION_MESSAGE);

                // jTextFieldNamaPembelian.setText("");
                // jTextFieldHargaPembelian.setText("");
                // jTextFieldKategoriPembelian.setText("");
                // jTextFieldQuantityPembelian.setText("");

                getTableDetailPembelian(jTextFieldIdPembelian.getText());
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                JOptionPane.showMessageDialog(null, "Pembelian Gagal!", "", JOptionPane.ERROR_MESSAGE);
                System.err.println(e.getMessage());
            }
        }

    }// GEN-LAST:event_jButtonTambahPembelianActionPerformed

    private void jTextFieldSubtotalActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextFieldSubtotalActionPerformed
        // add your handling code here:
    }// GEN-LAST:event_jTextFieldSubtotalActionPerformed

    private void jComboBoxSortActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jComboBoxSortActionPerformed
        // add your handling code here:
    }// GEN-LAST:event_jComboBoxSortActionPerformed

    private void jTextFieldIdPembelianActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextFieldIdPembelianActionPerformed
        // add your handling code here:
    }// GEN-LAST:event_jTextFieldIdPembelianActionPerformed

    private void jButtonHapusPembelianActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonHapusPembelianActionPerformed
        // add your handling code here:
    }// GEN-LAST:event_jButtonHapusPembelianActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
                    .getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PembelianMenu.class.getName()).log(
                    java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PembelianMenu.class.getName()).log(
                    java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PembelianMenu.class.getName()).log(
                    java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PembelianMenu.class.getName()).log(
                    java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PembelianMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonApplySort;
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonHapusTransaksi;
    private javax.swing.JButton jButtonRegisterMember;
    private javax.swing.JButton jButtonSearchBarang;
    private javax.swing.JButton jButtonSearchMember;
    private javax.swing.JButton jButtonSimpanTransaksi;
    private javax.swing.JButton jButtonTambahPembelian;
    private javax.swing.JComboBox<String> jComboBoxSort;
    private javax.swing.JComboBox<String> jComboBoxSort2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelDiskon;
    private javax.swing.JLabel jLabelHargaPembelian;
    private javax.swing.JLabel jLabelIdPembelian;
    private javax.swing.JLabel jLabelKategoriPembelian;
    private javax.swing.JLabel jLabelKembali;
    private javax.swing.JLabel jLabelNamaPembelian;
    private javax.swing.JLabel jLabelPembeli;
    private javax.swing.JLabel jLabelPembelianMenu;
    private javax.swing.JLabel jLabelQuantityPembelian;
    private javax.swing.JLabel jLabelSortBY;
    private javax.swing.JLabel jLabelSubtotal;
    private javax.swing.JLabel jLabelTableBarang;
    private javax.swing.JLabel jLabelTableMember;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JLabel jLabelTunai;
    private javax.swing.JLabel jLabelUserLogin;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTabelBarang;
    private javax.swing.JTable jTableDetailPembelian;
    private javax.swing.JTable jTableMember;
    private javax.swing.JTable jTablePembelian;
    private javax.swing.JTextField jTextFieldDiskon;
    private javax.swing.JTextField jTextFieldHargaPembelian;
    private javax.swing.JTextField jTextFieldIdPembelian;
    private javax.swing.JTextField jTextFieldKategoriPembelian;
    private javax.swing.JTextField jTextFieldKembali;
    private javax.swing.JTextField jTextFieldNamaPembelian;
    private javax.swing.JTextField jTextFieldPembeli;
    private javax.swing.JTextField jTextFieldQuantityPembelian;
    private javax.swing.JTextField jTextFieldSearchBarang;
    private javax.swing.JTextField jTextFieldSearchMember;
    private javax.swing.JTextField jTextFieldSubtotal;
    private javax.swing.JTextField jTextFieldTotal;
    private javax.swing.JTextField jTextFieldTunai;
    // End of variables declaration//GEN-END:variables
}
