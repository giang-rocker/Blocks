
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author MyPC
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    MainBoard mainboard;
    final int UNIT = 36;
    final int MARGIN_X = 30;
    final int MARGIN_Y = 50;

    boolean boardCheck[][];
     

    public MainFrame() {
        initComponents();
        this.setBackground(Color.black);
        mainboard = new MainBoard();
        mainboard.generateMainBoard();

        this.txt_GameInfo.setText(mainboard.width +" " +mainboard.height +"\n" + mainboard.numofBlock + "" + "");
        for (int i = 1; i <= mainboard.numofBlock; i++) {
            this.txt_GameInfo.setText(this.txt_GameInfo.getText() + "\n" + mainboard.listOfBlock[i].width + "  " + mainboard.listOfBlock[i].height);
        }

        isLoadSolution = false;
        txt_solution.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_generateGame1 = new java.awt.Button();
        button1 = new java.awt.Button();
        button2 = new java.awt.Button();
        button3 = new java.awt.Button();
        button4 = new java.awt.Button();
        txt_result = new java.awt.Label();
        txt_solution = new java.awt.TextArea();
        txt_GameInfo = new java.awt.TextArea();
        txt_result1 = new java.awt.Label();
        txt_result2 = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(255, 255, 255));

        txt_generateGame1.setLabel("New Game");
        txt_generateGame1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_generateGame1ActionPerformed(evt);
            }
        });

        button1.setLabel("Export Test");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        button2.setLabel("Load Test");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        button3.setLabel("Load Solution");
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });

        button4.setLabel("Hint");
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });

        txt_result.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txt_result.setForeground(new java.awt.Color(255, 0, 51));
        txt_result.setText("Result");

        txt_solution.setEditable(false);

        txt_GameInfo.setEditable(false);

        txt_result1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txt_result1.setForeground(new java.awt.Color(255, 0, 51));
        txt_result1.setText("Solution");

        txt_result2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txt_result2.setForeground(new java.awt.Color(255, 0, 51));
        txt_result2.setText("Test");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(txt_generateGame1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(362, 362, 362)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_result, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_result2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_result1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_GameInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                    .addComponent(txt_solution, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(txt_result2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_GameInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_result1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(txt_solution, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_generateGame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_result, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_generateGame1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_generateGame1ActionPerformed
        // TODO add your handling code here:
        this.txt_result.setText("Result:");
        mainboard = new MainBoard();
        mainboard.generateMainBoard();

        this.txt_GameInfo.setText(mainboard.width +" " +mainboard.height +"\n" + mainboard.numofBlock + "" + "");
        for (int i = 1; i <= mainboard.numofBlock; i++) {
            this.txt_GameInfo.setText(this.txt_GameInfo.getText() + "\n" + mainboard.listOfBlock[i].width + "  " + mainboard.listOfBlock[i].height);
        }

        isLoadSolution = false;
        txt_solution.setText("");
        this.repaint();
    }//GEN-LAST:event_txt_generateGame1ActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // TODO add your handling code here:
         try {
            // TODO add your handling code here:
            PrintWriter out = new PrintWriter("test.txt");

            out.println(mainboard.width + " " + mainboard.height);
            out.println(mainboard.numofBlock);
            for (int i = 1; i <= mainboard.numofBlock; i++) {
                out.println(mainboard.listOfBlock[i].width + "  " + mainboard.listOfBlock[i].height);
            }
            out.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_button1ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        this.txt_result.setText("Result:");
        JFileChooser jFileChooser = new JFileChooser();
        int result = jFileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                //    JOptionPane.showMessageDialog(this,"hii user clicked open sysytem");
                File file = jFileChooser.getSelectedFile();
                Scanner scanner = new Scanner(file);
                this.mainboard = new MainBoard();
                this.mainboard.width = scanner.nextInt();
                this.mainboard.height = scanner.nextInt();
                this.mainboard.numofBlock = scanner.nextInt();

                this.txt_GameInfo.setText("" + mainboard.width + " " + mainboard.height + "\n" + mainboard.numofBlock);

               mainboard.listOfBlock = new Blocks[mainboard.numofBlock+1];
                 

                for (int i = 1; i <= mainboard.numofBlock; i++) {
                    mainboard.listOfBlock[i] = new Blocks();
                    mainboard.listOfBlock[i].width = scanner.nextInt();
                    mainboard.listOfBlock[i].height = scanner.nextInt();
                     
                    this.txt_GameInfo.setText(this.txt_GameInfo.getText() + "\n" + mainboard.listOfBlock[i].width + " " + mainboard.listOfBlock[i].height );

                }
     } catch (FileNotFoundException ex) {

            } catch (IOException ex) {

            }
        }
        //    this.repaint();        // TODO add your handling code here:
    }//GEN-LAST:event_button2ActionPerformed

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
  this.repaint();
        JFileChooser jFileChooser = new JFileChooser();
        int result = jFileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                //    JOptionPane.showMessageDialog(this,"hii user clicked open sysytem");
                File file = jFileChooser.getSelectedFile();
                Scanner scanner = new Scanner(file);

                int numOfUsedBlock = scanner.nextInt();
                numOfRecordInSolution = numOfUsedBlock;
                

                this.txt_solution.setText("" + numOfUsedBlock);

                 Solution solution = new Solution(this.mainboard);
                 solution.numOfUseBlock = numOfRecordInSolution;
                 
                solution.boardCheck = new boolean[mainboard.width+1][mainboard.height+1];

                for (int i = 1; i <= solution.numOfBlock; i++) {
                    solution.listPosition[i][0] = scanner.nextInt();
                    solution.listPosition[i][1] = scanner.nextInt();
                   
                    this.txt_solution.setText(this.txt_solution.getText() + "\n" + solution.listPosition[i][0] + " " + solution.listPosition[i][1]);

                   

                }
                
                if (!solution.checkCorrectness()){
                    txt_result.setText("Result: INVALID Answer!");
                }
                else {
                     txt_result.setText("Result: VALID Answer!");
                isLoadSolution = true;
                drawSolution(this.getGraphics(), solution.listPosition, solution.numOfBlock);
                        }
                
            } catch (FileNotFoundException ex) {

            } catch (IOException ex) {

            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_button3ActionPerformed

    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button4ActionPerformed
 Solution solution = new Solution(mainboard);
        int countBlock = solution.getSolution();
        txt_solution.setText(countBlock + "");
        isLoadSolution = true;
        
        for (int i=1; i <= solution.numOfBlock; i ++)
         txt_solution.setText( txt_solution.getText() + "\n" + solution.listPosition[i][0] + " " + solution.listPosition[i][1] );
        
        // draw Solution
       // drawSolution(this.getGraphics(),solution.boardCheck);
        
        drawSolution(this.getGraphics(), solution.listPosition, solution.numOfBlock);        // TODO add your handling code here:
    }//GEN-LAST:event_button4ActionPerformed

    /**
     * @param args the command line arguments
     */
    boolean isLoadSolution = false;
    int numOfRecordInSolution;

    public void paint(Graphics g) {
        nextColor = 0;
        g.setColor(Color.white);
        g.drawRect(MARGIN_X, MARGIN_Y, mainboard.width * UNIT, mainboard.height * UNIT);

        g.setColor(Color.gray);
        for (int i = 1; i <= mainboard.width; i++) {
            for (int j = 1; j <= mainboard.height; j++) {
                drawBlock(g, i, j, false);
            }
        }

        
    }

    void drawSolution (Graphics g, int listPosition[][], int numOfBlock) {
     if (isLoadSolution) 
            for (int i =1; i <=numOfBlock; i++) 
            if ( listPosition[i][0] !=-1 &&  listPosition[i][1] !=-1 ) {
                drawBlock(g, listPosition[i][0], listPosition[i][1], mainboard.listOfBlock[i].width, mainboard.listOfBlock[i].height  );
                g.setColor(Color.red);
                g.setFont(new Font("TimesRoman", Font.BOLD, 15));
                g.drawString(i+"", MARGIN_X+3+ (listPosition[i][0]-1)*UNIT,MARGIN_Y+3+ (listPosition[i][1]-1)*UNIT+15);
            }
         
    }    
    void drawSolution (Graphics g, boolean boardCheck[][]) {
     if (isLoadSolution) 
             for (int i = 1; i <= mainboard.width; i++) {
                for (int j = 1; j<= mainboard.height; j++) {
                    drawBlock(g, i, j, boardCheck[i][j]);
                }
            }
         
    }  
    Color listColor[] = {Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN, Color.ORANGE, Color.YELLOW};
    int nextColor = 0;
    public void drawBlock(Graphics g, int x, int y, int w, int h) {

        g.setColor(listColor[(nextColor++)%listColor.length]);
        g.fillRect(MARGIN_X + (x-1) * UNIT, MARGIN_Y + (y-1) * UNIT, w * UNIT, h * UNIT);
        g.setColor(Color.black);
        g.drawRect(MARGIN_X + (x-1) * UNIT, MARGIN_Y + (y-1) * UNIT, w * UNIT, h * UNIT);

    }

    public void drawBlock(Graphics g, int x, int y, boolean isGrass) {

        if (!isGrass) {
            g.drawImage(Asset.nullBlock.image, MARGIN_X + (x-1) * UNIT, MARGIN_Y + (y-1) * UNIT, this);
        } else {
            g.drawImage(Asset.grassBlock.image, MARGIN_X + (x-1) * UNIT, MARGIN_Y + (y-1) * UNIT, this);
        }

    }

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private java.awt.Button button2;
    private java.awt.Button button3;
    private java.awt.Button button4;
    private java.awt.TextArea txt_GameInfo;
    private java.awt.Button txt_generateGame1;
    private java.awt.Label txt_result;
    private java.awt.Label txt_result1;
    private java.awt.Label txt_result2;
    private java.awt.TextArea txt_solution;
    // End of variables declaration//GEN-END:variables
}
