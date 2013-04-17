package src;



public class BusList extends javax.swing.JPanel {
	private static final long serialVersionUID = 1L;
	public BusList(String row[][]) {
        initComponents(row);
        jLabel8.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents(String row[][]) {

        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textField2 = new java.awt.TextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();

        setBackground(java.awt.Color.white);

        jLabel1.setBackground(java.awt.Color.white);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/ChakkaLogoSmall.jpg"))); // NOI18N

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/NameSmall.jpg"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/ChoosePlaceToGo.jpg"))); // NOI18N

        textField2.setBackground(java.awt.Color.white);
        textField2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        textField2.setFont(new java.awt.Font("AnjaliOldLipi", 1, 24)); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/AdakkukaBlack.jpg"))); // NOI18N

        jTable1.setBorder(null);
        jTable1.setFont(new java.awt.Font("AnjaliOldLipi",1,13));
        jTable1.setRowHeight(31);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(row,
            new String [] {
                "Bus No", "Arrival Time", "Fair", "Route"
            }
        ) {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Vyakthamalla.gif"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel9)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 835, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 232, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textField2, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textField2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)))
                            .addComponent(jLabel4))
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 144, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private java.awt.TextField textField2;
    public boolean isCellEditable(int row, int col ){
 	   return false;    	   
    }
    // End of variables declaration//GEN-END:variables

    
  /*  public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.add(new BusList(),BorderLayout.CENTER);
        frame.setSize(1366, 768);
        frame.setVisible(true);
        System.out.print("slafdljas");
    }*/



}


