package src;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;


public class ImportantNews extends javax.swing.JPanel {

  
	
	private static final long serialVersionUID = 1L;
	
	
	
	public ImportantNews(String Name) {
        initComponents(Name);
        jLabel5.setVisible(false);
    }

    
   
    private void initComponents(String Name) {

        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        String s = "\n";
        int i=0;
        BufferedReader demo = null;
        String sCurrentLine;
		try {
			demo = new BufferedReader(new FileReader(Name));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        setBackground(java.awt.Color.white);
        setPreferredSize(new java.awt.Dimension(1366, 768));

        jLabel1.setBackground(java.awt.Color.white);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/ChakkaLogoSmall.jpg"))); // NOI18N

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/NameSmall.jpg"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/AdakkukaBlack.jpg"))); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Vyakthamalla.gif"))); // NOI18N

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("AnjaliOldLipi", 0, 18)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setBorder(null);
        jTextArea1.setFont(new java.awt.Font("AnjaliOldLipi", 1, 24));
        try {
        	i=0;
			while ((sCurrentLine = demo.readLine()) != null){
				jTextArea1.append(sCurrentLine);
				jTextArea1.append(s);
				i++;
		if(i>3)
			break;
		}
		} catch (IOException e) {
				e.printStackTrace();
		} finally {
			try {
				if (demo != null)demo.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
        jTextArea1.setEditable(false);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel9)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 942, Short.MAX_VALUE)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 949, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
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
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(41, 41, 41)
                .addComponent(jLabel5)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

  /* public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.add(new ImportantNews(),BorderLayout.CENTER);
        frame.setSize(1366, 768);
        frame.setVisible(true); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }*/
   
}
