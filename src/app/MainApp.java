/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.io.*;
import java.util.Vector;
import java.util.concurrent.TimeUnit;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javazoom.jl.player.Player;

/**
 *
 * @author Admin
 */
public class MainApp extends javax.swing.JFrame {

    /**
     * Creates new form MainApp
     */
    
    JFileChooser fileDialog = new JFileChooser();
    String fileName;
    Player player;
    Thread playingThread;
    Thread strackBarThread;
    int max = 0;
    Vector header = new Vector();
    Vector data = new Vector();
    DefaultTableModel tblModel;
    String fileList = "data\\songList.txt";
    public MainApp() {
        initComponents();
        setLocationRelativeTo(null);
        
        header.add("Tên bài hát");
        header.add("Thời lượng");
        header.add("Vị trí");
        
        loadSongList();
        
        tblModel = (DefaultTableModel) tblSongList.getModel();
        tblModel.setDataVector(data, header);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtSelectedFile = new javax.swing.JTextField();
        btnOpen = new javax.swing.JButton();
        sliderProcess = new javax.swing.JSlider();
        btnStart = new javax.swing.JButton();
        btnStop = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSongList = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mniOpen = new javax.swing.JMenuItem();
        mniStart = new javax.swing.JMenuItem();
        mniStop = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mniExit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mniAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("iTomato Player");

        jLabel1.setText("Tệp tin đang mở");

        btnOpen.setText("Chọn bài");
        btnOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenActionPerformed(evt);
            }
        });

        sliderProcess.setForeground(new java.awt.Color(153, 153, 153));

        btnStart.setText("Bắt đầu");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        btnStop.setText("Kết thúc");
        btnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopActionPerformed(evt);
            }
        });

        btnRemove.setText("Xóa khỏi danh sách");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btnSave.setText("Lưu danh sách");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnAdd.setText("Thêm bài hát");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        tblSongList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblSongList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSongListMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblSongListMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblSongList);

        jMenu1.setText("File");

        mniOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        mniOpen.setText("Chọn tệp tin");
        jMenu1.add(mniOpen);

        mniStart.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        mniStart.setText("Bắt đầu");
        jMenu1.add(mniStart);

        mniStop.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        mniStop.setText("Kết thúc");
        jMenu1.add(mniStop);
        jMenu1.add(jSeparator1);

        mniExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        mniExit.setText("Thoát ứng dụng");
        jMenu1.add(mniExit);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        mniAbout.setText("Thông tin ứng dụng");
        jMenu2.add(mniAbout);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtSelectedFile)
                        .addGap(18, 18, 18)
                        .addComponent(btnOpen))
                    .addComponent(sliderProcess, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnStart)
                        .addGap(18, 18, 18)
                        .addComponent(btnStop)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                        .addComponent(btnAdd)
                        .addGap(18, 18, 18)
                        .addComponent(btnSave)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemove))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSelectedFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOpen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sliderProcess, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnStart)
                    .addComponent(btnStop)
                    .addComponent(btnRemove)
                    .addComponent(btnSave)
                    .addComponent(btnAdd))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private int getDuration(File f) throws Exception{
        int mili = 0;
        int sec = 0;
        AudioFileFormat fileFormat = AudioSystem.getAudioFileFormat(f);
        long microsecond = (long)fileFormat.properties().get("duration");
        mili = (int)(microsecond/100);
        sec = mili/100;
        return sec;
    }
    private String getDurationFormat(File f) throws Exception{
        AudioFileFormat fileFormat = AudioSystem.getAudioFileFormat(f);
        long microsecond = (long)fileFormat.properties().get("duration");
        long sec = TimeUnit.MICROSECONDS.toSeconds(microsecond);
        long minute = TimeUnit.MICROSECONDS.toMinutes(microsecond);
        long hour = TimeUnit.MICROSECONDS.toHours(microsecond);
        return hour + ":" + minute + ":" + sec;
    }
    private void btnOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenActionPerformed
        // TODO add your handling code here:
        try {
            int result = fileDialog.showOpenDialog(this);
            if(result == JFileChooser.APPROVE_OPTION){
                File f = fileDialog.getSelectedFile();
                if(f.isFile()){
                    this.txtSelectedFile.setText(f.getCanonicalPath());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnOpenActionPerformed

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        // TODO add your handling code here:
        fileName = txtSelectedFile.getText();
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        File f = new File(fileName);
        try {
            fis = new FileInputStream(f);
            bis = new BufferedInputStream(fis);
            player = new Player(bis);
            max = getDuration(f);
            sliderProcess.setMaximum(max);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        playingThread = new Thread(){
            public void run(){
                try {
                    player.play();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        };
        strackBarThread = new Thread(){
          public void run(){
            try {
                int n = 0;
                //Kiem tra bai hat da chay xong && thread chay bai hat con chay hay khong?
                while(!player.isComplete() && playingThread.isAlive()){
                    sliderProcess.setValue(n++);
                    Thread.sleep(1000);
                }
                sliderProcess.setValue(max);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            btnStopActionPerformed(null);
          }  
        };
        playingThread.start();
        strackBarThread.start();
        btnStart.setEnabled(false);
        btnStop.setEnabled(true);
    }//GEN-LAST:event_btnStartActionPerformed

    private void btnStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopActionPerformed
        // TODO add your handling code here:
        if(player != null){
            player.close();
        }
        btnStart.setEnabled(true);
        btnStop.setEnabled(false);
        sliderProcess.setValue(0);
        playingThread.interrupt();
        strackBarThread.interrupt();
    }//GEN-LAST:event_btnStopActionPerformed

    void addFileToTable(File[] files) throws Exception{
        for(File song : files){
            String name = song.getName();
            String duration = getDurationFormat(song);
            String location = song.getCanonicalPath();
            
            Vector v = new Vector();
            v.add(name);
            v.add(duration);
            v.add(location);
            data.add(v);
        }
        tblSongList.updateUI();
    }
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        fileDialog.setMultiSelectionEnabled(true); //Cho phep chon nhieu file
        int result = fileDialog.showOpenDialog(this);
        if(result == JFileChooser.APPROVE_OPTION){
            File[] files = fileDialog.getSelectedFiles();
            try {
                addFileToTable(files);
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void tblSongListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSongListMouseClicked
        // TODO add your handling code here:
        int row = tblSongList.getSelectedRow();
        String location = tblSongList.getValueAt(row, 2).toString();
        txtSelectedFile.setText(location);
        
        if(evt.getClickCount() == 2){
            if(playingThread != null){
                btnStopActionPerformed(null);
            }
            btnStartActionPerformed(null);
        }
    }//GEN-LAST:event_tblSongListMouseClicked

    private void tblSongListMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSongListMouseReleased
        // TODO add your handling code here:
        int row = tblSongList.getSelectedRow();
        int column = tblSongList.getSelectedColumn();
        
        //Huy che do chinh sua
        tblSongList.getCellEditor(row, column).cancelCellEditing();
    }//GEN-LAST:event_tblSongListMouseReleased

    void loadSongList(){
        try {
            FileReader fr = new FileReader(fileList);
            BufferedReader br = new BufferedReader(fr);
            String song;
            while((song = br.readLine()) != null){
                String info[] = song.split(",");
                String name = info[0];
                String duration = info[1];
                String location = info[2];
                Vector row = new Vector();
                row.add(name);
                row.add(duration);
                row.add(location);
                data.add(row);
            }
            br.close(); fr.close();
        } catch (Exception e) {
        }
    }
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        try {
            File f = new File(fileList);
            PrintWriter pw = new PrintWriter(f);
            int n = data.size();
            for(int i = 0; i < n; i++){
                Vector row = (Vector) data.get(i);
                String s = row.get(0) + "," + row.get(1) + "," + row.get(2);
                pw.println(s);
            }
            pw.close();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        // TODO add your handling code here:
        int pos = tblSongList.getSelectedRow();
        if(pos >= 0){
            int result = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa?", 
                    "Xác nhận", JOptionPane.YES_NO_OPTION);
            if(result == JOptionPane.YES_OPTION){
                data.remove(pos);
                tblSongList.updateUI();
            }
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

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
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainApp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnOpen;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnStart;
    private javax.swing.JButton btnStop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem mniAbout;
    private javax.swing.JMenuItem mniExit;
    private javax.swing.JMenuItem mniOpen;
    private javax.swing.JMenuItem mniStart;
    private javax.swing.JMenuItem mniStop;
    private javax.swing.JSlider sliderProcess;
    private javax.swing.JTable tblSongList;
    private javax.swing.JTextField txtSelectedFile;
    // End of variables declaration//GEN-END:variables
}
