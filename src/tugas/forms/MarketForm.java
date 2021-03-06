/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas.forms;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import tugas.base.MainForm;
import tugas.startform.SignInForm;
import tugas.utils.ConnectionUtil;
import tugas.utils.Session;

public class MarketForm extends javax.swing.JFrame {

    /**
     * Creates new form ArtistForm
     */
    
    private DefaultTableModel model;
    private DefaultTableModel model2;
    
    public MarketForm() {
        initComponents();

        model = new DefaultTableModel();
        model2 = new DefaultTableModel();

        TableArtists.setModel(model);        
        model.addColumn("id");
        model.addColumn("name");
        model.addColumn("balance");
        model.addColumn("email");
        model.addColumn("phone");
        model.addColumn("genre");
        model.addColumn("instagram");
        
        TableSong.setModel(model2);
        model2.addColumn("id");
        model2.addColumn("title");
        model2.addColumn("duratiom");
        model2.addColumn("price");
        model2.addColumn("album id");

        loadDataArtist();
        loadDataSong();
    }
    
    public void loadDataArtist() {
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();

        try {
            Connection c = ConnectionUtil.getConnection();
            Statement s = c.createStatement();
            String sql = "SELECT * FROM tb_artist_meianly";
            ResultSet r = s.executeQuery(sql);
            while (r.next()) {
                // lakukan penulusuran baris
                Object[] o = new Object[7];
                o[0] = r.getString("id");
                o[1] = r.getString("name");
                o[2] = r.getBigDecimal("balance");
                o[3] = r.getString("email");
                o[4] = r.getString("phone");
                o[5] = r.getString("genre");
                o[6] = r.getString("instagram");
                model.addRow(o);
            }

            r.close();
            s.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void loadDataSong() {
        model2.getDataVector().removeAllElements();
        model2.fireTableDataChanged();

        try {
            Connection c = ConnectionUtil.getConnection();
            Statement s = c.createStatement();
            String sql = "SELECT * FROM tb_song_meianly";
            ResultSet r = s.executeQuery(sql);
            while (r.next()) {
                // lakukan penulusuran baris
                Object[] o = new Object[5];
                o[0] = r.getString("id");
                o[1] = r.getString("title");
                o[2] = r.getInt("duration");
                o[3] = r.getBigDecimal("price");
                o[4] = r.getInt("album_id");
                model2.addRow(o);
            }

            r.close();
            s.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sell = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        BHome = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        TableSong = new javax.swing.JTable();
        inputGenre = new javax.swing.JTextField();
        inputInstagram = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        inputName = new javax.swing.JTextField();
        inputEmail = new javax.swing.JTextField();
        inputPhone = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableArtists = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        inputTitle = new javax.swing.JTextField();
        inputDuration = new javax.swing.JTextField();
        inputPrice = new javax.swing.JTextField();
        inputAlbumId = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        BHome1 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        inputBalance = new javax.swing.JTextField();
        buy = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        sell.setText("SELL");
        sell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sellActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("SONGS");

        BHome.setText("HOME");
        BHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BHomeActionPerformed(evt);
            }
        });

        TableSong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Title", "Duration", "Price", "Album Id"
            }
        ));
        TableSong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableSongMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TableSong);
        if (TableSong.getColumnModel().getColumnCount() > 0) {
            TableSong.getColumnModel().getColumn(2).setResizable(false);
        }

        inputGenre.setEditable(false);
        inputGenre.setForeground(new java.awt.Color(0, 153, 0));

        inputInstagram.setEditable(false);
        inputInstagram.setForeground(new java.awt.Color(0, 153, 0));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Email");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Phone");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("Genre");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("Instagram");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Name");

        inputName.setEditable(false);
        inputName.setForeground(new java.awt.Color(0, 153, 0));

        inputEmail.setEditable(false);
        inputEmail.setForeground(new java.awt.Color(0, 153, 0));

        inputPhone.setEditable(false);
        inputPhone.setForeground(new java.awt.Color(0, 153, 0));

        TableArtists.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Balance", "Email", "Phone", "Genre", "Instagram"
            }
        ));
        TableArtists.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableArtistsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TableArtists);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setText("ARTIST");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel3.setText("MARKET");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("TItle");

        inputTitle.setEditable(false);
        inputTitle.setForeground(new java.awt.Color(153, 0, 0));

        inputDuration.setEditable(false);
        inputDuration.setForeground(new java.awt.Color(153, 0, 0));

        inputPrice.setEditable(false);
        inputPrice.setForeground(new java.awt.Color(153, 0, 0));

        inputAlbumId.setEditable(false);
        inputAlbumId.setForeground(new java.awt.Color(153, 0, 0));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setText("Duration");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setText("Price");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel17.setText("Album Id");

        BHome1.setText("REFRESH");
        BHome1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BHome1ActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setText("Balance");

        inputBalance.setEditable(false);
        inputBalance.setForeground(new java.awt.Color(0, 153, 0));

        buy.setText("BUY");
        buy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(sell, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buy, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(44, 44, 44)
                                    .addComponent(inputName, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel18)
                                        .addComponent(jLabel11)
                                        .addComponent(jLabel12)
                                        .addComponent(jLabel13)
                                        .addComponent(jLabel14))
                                    .addGap(44, 44, 44)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(inputEmail)
                                        .addComponent(inputPhone)
                                        .addComponent(inputGenre)
                                        .addComponent(inputInstagram, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(inputBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 490, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(44, 44, 44)
                                .addComponent(inputTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel17))
                                .addGap(44, 44, 44)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(inputDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(inputPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(inputAlbumId, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(452, 452, 452)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BHome1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BHome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BHome1)))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(inputName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(inputEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(inputPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inputGenre, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inputInstagram, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inputBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(inputTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(inputDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(inputPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inputAlbumId, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sell)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buy)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void sellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sellActionPerformed

        int i = TableArtists.getSelectedRow();
        if (i == -1) {
            // tidak ada baris yang tedeteksi
            return;
        }

        // ambil field balance dari artist
        String nameInput = inputName.getText();
        BigDecimal balance = new BigDecimal(inputBalance.getText());
        String emailInput = inputEmail.getText();
        String phoneInput = inputPhone.getText();
        String genreInput = inputGenre.getText();
        String instagramInput = inputInstagram.getText();

        // ambil field price dari song
        String title = inputTitle.getText();
        int duration = Integer.parseInt(inputDuration.getText());
        BigDecimal price = new BigDecimal(inputPrice.getText());
        int album = Integer.parseInt(inputAlbumId.getText());
                
            BigDecimal addBalance = balance.add(price); // aritmatika penjumlahan
            inputBalance.setText(addBalance.toString());
            try {

                String name = model.getValueAt(i, 1).toString();

                nameInput = inputName.getText();
                balance = new BigDecimal(inputBalance.getText());
                emailInput = inputEmail.getText();
                phoneInput = inputPhone.getText();
                genreInput = inputGenre.getText();
                instagramInput = inputInstagram.getText();

                Connection c = ConnectionUtil.getConnection();

                String sql = "UPDATE tb_artist_meianly SET name = ?, email = ?, balance = ?, phone= ?, genre= ?, instagram = ? where name = ?";
                PreparedStatement p = c.prepareStatement(sql);
                p.setString(1, nameInput);
                p.setString(2, emailInput);
                p.setBigDecimal(3, balance);
                p.setString(4, phoneInput);
                p.setString(5, genreInput);
                p.setString(6, instagramInput);
                p.setString(7, name);

                p.executeUpdate();
                p.close();

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    Connection c = ConnectionUtil.getConnection();
                    String sql = "INSERT INTO tb_transaction_meianly(email,title,status) VALUES (?,?,?)";
                    PreparedStatement p = c.prepareStatement(sql);
                    
                    p.setString(1, emailInput);
                    p.setString(2, title);
                    p.setString(3, "SELL");
                    
                    p.executeUpdate();
                    p.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("terjadi error pada saat insert data");
                } finally {
                    loadDataArtist();
                    loadDataSong();
                }
                
                loadDataArtist();
                loadDataSong();
            }
    }//GEN-LAST:event_sellActionPerformed

    private void BHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BHomeActionPerformed
        new MainForm().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BHomeActionPerformed

    private void TableSongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableSongMouseClicked
        int i = TableSong.getSelectedRow();
        if (i == -1) {
            // tidak ada baris yang tedeteksi
            return;
        }

        String title = model2.getValueAt(i, 1).toString();
        inputTitle.setText(title);

        String duration = model2.getValueAt(i, 2).toString();
        inputDuration.setText(duration);

        String price = model2.getValueAt(i, 3).toString();
        inputPrice.setText(price);

        String albumId = model2.getValueAt(i, 4).toString();
        inputAlbumId.setText(albumId);
        
    }//GEN-LAST:event_TableSongMouseClicked

    private void TableArtistsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableArtistsMouseClicked

        int i = TableArtists.getSelectedRow();
        if (i == -1) {
            // tidak ada baris yang tedeteksi
            return;
        }

        String name = (String) model.getValueAt(i, 1);
        inputName.setText(name);
        
        BigDecimal balance = (BigDecimal) model.getValueAt(i, 2);
        inputBalance.setText(balance.toString());

        String email = (String) model.getValueAt(i, 3);
        inputEmail.setText(email);
        
        String phone = (String) model.getValueAt(i, 4);
        inputPhone.setText(phone);
        
        String genre = (String) model.getValueAt(i, 5);
        inputGenre.setText(genre);
        
        String ig = (String) model.getValueAt(i, 6);
        inputInstagram.setText(ig);
    }//GEN-LAST:event_TableArtistsMouseClicked

    private void BHome1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BHome1ActionPerformed
        MarketForm af = new MarketForm();
        af.setResizable(false);
        af.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        af.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BHome1ActionPerformed

    private void buyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyActionPerformed

        int i = TableArtists.getSelectedRow();
        if (i == -1) {
            // tidak ada baris yang tedeteksi
            return;
        }

        // ambil field balance dari artist
        String nameInput = inputName.getText();
        BigDecimal balance = new BigDecimal(inputBalance.getText());
        String emailInput = inputEmail.getText();
        String phoneInput = inputPhone.getText();
        String genreInput = inputGenre.getText();
        String instagramInput = inputInstagram.getText();

        // ambil field price dari song
        String title = inputTitle.getText();
        int duration = Integer.parseInt(inputDuration.getText());
        BigDecimal price = new BigDecimal(inputPrice.getText());
        int album = Integer.parseInt(inputAlbumId.getText());

        if (balance.compareTo(price) == -1) {
            JOptionPane.showMessageDialog(null, "SALDO ANDA TIDAK CUKUP");
        } else {
            BigDecimal substractBalance = balance.subtract(price); // aritmatika penguranngan
            inputBalance.setText(substractBalance.toString());
            try {

                String name = model.getValueAt(i, 1).toString();

                nameInput = inputName.getText();
                balance = new BigDecimal(inputBalance.getText());
                emailInput = inputEmail.getText();
                phoneInput = inputPhone.getText();
                genreInput = inputGenre.getText();
                instagramInput = inputInstagram.getText();

                Connection c = ConnectionUtil.getConnection();

                String sql = "UPDATE tb_artist_meianly SET name = ?, email = ?, balance = ?, phone= ?, genre= ?, instagram = ? where name = ?";
                PreparedStatement p = c.prepareStatement(sql);
                p.setString(1, nameInput);
                p.setString(2, emailInput);
                p.setBigDecimal(3, balance);
                p.setString(4, phoneInput);
                p.setString(5, genreInput);
                p.setString(6, instagramInput);
                p.setString(7, name);

                p.executeUpdate();
                p.close();

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    Connection c = ConnectionUtil.getConnection();
                    String sql = "INSERT INTO tb_transaction_meianly(email,title,status) VALUES (?,?,?)";
                    PreparedStatement p = c.prepareStatement(sql);

                    p.setString(1, emailInput);
                    p.setString(2, title);
                    p.setString(3, "BUY");

                    p.executeUpdate();
                    p.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("terjadi error pada saat insert data");
                } finally {
                    loadDataArtist();
                    loadDataSong();
                }
                
                loadDataArtist();
                loadDataSong();
            }

        }       
       


    }//GEN-LAST:event_buyActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MarketForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MarketForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MarketForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MarketForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MarketForm af = new MarketForm();
                af.setVisible(true);
                af.setResizable(false);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BHome;
    private javax.swing.JButton BHome1;
    public javax.swing.JTable TableArtists;
    public javax.swing.JTable TableSong;
    private javax.swing.JButton buy;
    private javax.swing.JTextField inputAlbumId;
    private javax.swing.JTextField inputBalance;
    private javax.swing.JTextField inputDuration;
    private javax.swing.JTextField inputEmail;
    private javax.swing.JTextField inputGenre;
    private javax.swing.JTextField inputInstagram;
    private javax.swing.JTextField inputName;
    private javax.swing.JTextField inputPhone;
    private javax.swing.JTextField inputPrice;
    private javax.swing.JTextField inputTitle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton sell;
    // End of variables declaration//GEN-END:variables
}
