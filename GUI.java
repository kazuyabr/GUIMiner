import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author yesiam77
 */
@SuppressWarnings("serial")
public class GUI extends javax.swing.JFrame {

    /**
     * Creates new form GUI
     */
    public GUI() {
        super("GUI Miner");
        ImageIcon image1 = new javax.swing.ImageIcon(getClass().getResource("Icon.png"));
        Image img = image1.getImage().getScaledInstance(image1.getIconWidth(),image1.getIconHeight(),Image.SCALE_SMOOTH);
        
        super.setIconImage(img);
        
        try
        {
        	for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            	if ("Windows".equals(info.getName()))
            	{
            		javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
            	}
            
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        initComponents();
    }
    
    public JTabbedPane getTabPane()
    {
    	return Tabs;
    }
    
    public JList<String> getGPUsAvailableList()
    {
    	return GPUsAvailableList;
    }
    
    public JComboBox<String> getAlgoCombobox()
    {
    	return AlgorithmCombobox;
    }
    
    public JTextArea getConsoleTextArea()
    {
    	return ConsoleTextArea;
    }
    
    public JTextArea getMonitorTextArea()
    {
    	return jTextArea1;
    }
    
    public JButton getStartMinerButton()
    {
    	return StartMinerButton;
    }
    
    public JTextField getPoolURLField()
    {
    	return PoolURLTextInput;
    }
    
    public JTextField getUsernameField()
    {
    	return UsernameTextInput;
    }
    
    public JTextField getPasswordField()
    {
    	return PasswordTextInput;
    }
    
    public JTextField getAdvCMDField()
    {
    	return AdvancedCommandlineTextInput;
    }
    
    public JTextField getTotalHashrateField()
    {
    	return TotalHashrateField;
    }
    
    public JTextField getTotalGPUsHashingField()
    {
    	return TotalGPUsHashingField;
    }
    
    public JTextField getAlgorithmField()
    {
    	return AlgorithmField;
    }
    
    public JTextField getAvgTempField()
    {
    	return AvgTempField;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    @SuppressWarnings("deprecation")
	private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Tabs = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jSplitPane2 = new javax.swing.JSplitPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        GPUsIntensityList = new javax.swing.JList<>();
        jLabel10 = new javax.swing.JLabel();
        jSplitPane3 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        GPUsAvailableList = new javax.swing.JList<>();
        jLabel9 = new javax.swing.JLabel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        PoolURLTextInput = new javax.swing.JTextField();
        UsernameTextInput = new javax.swing.JTextField();
        PasswordTextInput = new javax.swing.JTextField();
        StartMinerButton = new javax.swing.JButton();
        AdvancedCommandlineTextInput = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        AlgorithmCombobox = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        MonitorPane = new javax.swing.JPanel();
        jSplitPane4 = new javax.swing.JSplitPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        TotalHashrateField = new javax.swing.JTextField();
        TotalGPUsHashingField = new javax.swing.JTextField();
        AlgorithmField = new javax.swing.JTextField();
        AvgTempField = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        ConsoleTextArea = new javax.swing.JTextArea();
        jPanel6 = new javax.swing.JPanel();
        HelpScrollPane = new javax.swing.JScrollPane();
        HelpTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jSplitPane2.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        GPUsIntensityList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        GPUsIntensityList.setNextFocusableComponent(AlgorithmCombobox);
        jScrollPane2.setViewportView(GPUsIntensityList);
        GPUsIntensityList.getAccessibleContext().setAccessibleName("GPUsIntensityList");

        jSplitPane2.setRightComponent(jScrollPane2);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("GPU Intensity");
        jSplitPane2.setTopComponent(jLabel10);

        jSplitPane3.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        GPUsAvailableList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        GPUsAvailableList.setNextFocusableComponent(GPUsIntensityList);
        jScrollPane1.setViewportView(GPUsAvailableList);
        GPUsAvailableList.getAccessibleContext().setAccessibleName("GPUsAvailableList");

        jSplitPane3.setRightComponent(jScrollPane1);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Available GPUS");
        jSplitPane3.setTopComponent(jLabel9);

        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Options");
        jSplitPane1.setTopComponent(jLabel1);

        jLabel2.setText("Pool URL* (-o)");

        jLabel3.setText("Username* (-u)");

        jLabel4.setText("Password (-p)");

        PoolURLTextInput.setText("stratum+tcp://");
        PoolURLTextInput.setToolTipText("This is a required field.");
        PoolURLTextInput.setNextFocusableComponent(UsernameTextInput);


        UsernameTextInput.setToolTipText("This is a required field.");
        UsernameTextInput.setNextFocusableComponent(PasswordTextInput);


        PasswordTextInput.setToolTipText("This is an optional field.");
        PasswordTextInput.setNextFocusableComponent(AdvancedCommandlineTextInput);


        StartMinerButton.setText("Start Miner");
        StartMinerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartMinerButtonActionPerformed(evt);
            }
        });

        AdvancedCommandlineTextInput.setToolTipText("This is an optional field.");
        AdvancedCommandlineTextInput.setNextFocusableComponent(StartMinerButton);


        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Advanced Commandline Options");

        jLabel6.setForeground(java.awt.Color.gray);
        jLabel6.setText("* required");

        jLabel11.setText("Algorithm* (-a)");

        AlgorithmCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(Wrapper.getFullAlgoList()));
        AlgorithmCombobox.setToolTipText("This is a required field.");
        AlgorithmCombobox.setNextFocusableComponent(PoolURLTextInput);


        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(AdvancedCommandlineTextInput))
                        .addGap(10, 10, 10)
                        .addComponent(StartMinerButton))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel11))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PoolURLTextInput)
                            .addComponent(AlgorithmCombobox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PasswordTextInput, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(UsernameTextInput, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE))))
                .addGap(10, 10, 10))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(13, 13, 13)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(AlgorithmCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(PoolURLTextInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(UsernameTextInput))
                .addGap(40, 40, 40)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(PasswordTextInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jLabel5)
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StartMinerButton)
                    .addComponent(AdvancedCommandlineTextInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        PoolURLTextInput.getAccessibleContext().setAccessibleName("PoolURLTextInput");
        UsernameTextInput.getAccessibleContext().setAccessibleName("UsernameTextInput");
        PasswordTextInput.getAccessibleContext().setAccessibleName("PasswordTextInput");
        PasswordTextInput.getAccessibleContext().setAccessibleDescription("This is an optional field.");
        StartMinerButton.getAccessibleContext().setAccessibleDescription("Push this to start the miner.");
        AdvancedCommandlineTextInput.getAccessibleContext().setAccessibleName("AdvancedCommandlineTextInput");
        AdvancedCommandlineTextInput.getAccessibleContext().setAccessibleDescription("This is an optional field.");
        AlgorithmCombobox.getAccessibleContext().setAccessibleName("AlgorithmCombobox");

        jSplitPane1.setRightComponent(jPanel4);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Options");
        jSplitPane1.setTopComponent(jLabel7);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Options");
        jSplitPane1.setTopComponent(jLabel8);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSplitPane1)
                    .addComponent(jSplitPane3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        Tabs.addTab("Settings", jPanel2);

        jSplitPane4.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Total Hashrate");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("# of GPUs Hashing");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Algorithm");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Avg Temp (C)");

        TotalHashrateField.setEditable(false);
        TotalHashrateField.setText("N/A");

        TotalGPUsHashingField.setEditable(false);
        TotalGPUsHashingField.setText("N/A");

        AlgorithmField.setEditable(false);
        AlgorithmField.setText("N/A");

        AvgTempField.setEditable(false);
        AvgTempField.setText("N/A");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TotalHashrateField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TotalGPUsHashingField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(199, 199, 199)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AvgTempField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AlgorithmField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(125, 125, 125))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel14)
                    .addComponent(TotalHashrateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AlgorithmField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel15)
                    .addComponent(TotalGPUsHashingField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AvgTempField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        jSplitPane4.setTopComponent(jPanel3);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 969, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
        );

        jSplitPane4.setRightComponent(jPanel7);

        javax.swing.GroupLayout MonitorPaneLayout = new javax.swing.GroupLayout(MonitorPane);
        MonitorPane.setLayout(MonitorPaneLayout);
        MonitorPaneLayout.setHorizontalGroup(
            MonitorPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane4)
        );
        MonitorPaneLayout.setVerticalGroup(
            MonitorPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane4)
        );

        Tabs.addTab("Monitor", MonitorPane);

        ConsoleTextArea.setEditable(false);
        ConsoleTextArea.setColumns(20);
        ConsoleTextArea.setRows(5);
        jScrollPane4.setViewportView(ConsoleTextArea);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 971, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
        );

        Tabs.addTab("Console", jPanel5);

        HelpTextArea.setEditable(false);
        HelpTextArea.setColumns(20);
        HelpTextArea.setRows(5);
        HelpTextArea.setText("------------------------------CCMiner----------------------------------------------------------------\n>>> Command Line Interface Arguments <<<\n\n  -a, --algo=ALGO       specify the algorithm to use\n                          allium      use to mine Garlic\n                          bastion     use to mine Joincoin\n                          bitcore     use to mine Bitcore's Timetravel10\n                          blake       use to mine Saffroncoin (Blake256)\n                          blakecoin   use to mine Old Blake 256\n                          blake2s     use to mine Nevacoin (Blake2-S 256)\n                          bmw         use to mine Midnight\n                          cryptolight use to mine AEON cryptonight variant 1 (MEM/2)\n                          cryptonight use to mine original cryptonight\n                          c11/flax    use to mine Chaincoin and Flax\n                          decred      use to mine Decred 180 bytes Blake256-14\n                          deep        use to mine Deepcoin\n                          dmd-gr      use to mine Diamond-Groestl\n                          equihash    use to mine ZEC, HUSH and KMD\n                          fresh       use to mine Freshcoin\n                          fugue256    use to mine Fuguecoin\n                          groestl     use to mine Groestlcoin\n                          hsr         use to mine Hshare\n                          jackpot     use to mine Sweepcoin\n                          keccak      use to mine Maxcoin\n                          keccakc     use to mine CreativeCoin\n                          lbry        use to mine LBRY Credits\n                          luffa       use to mine Joincoin\n                          lyra2       use to mine CryptoCoin\n                          lyra2v2     use to mine Vertcoin\n                          lyra2z      use to mine Zerocoin (XZC)\n                          monero      use to mine Monero (XMR)\n                          myr-gr      use to mine Myriad-Groest\n                          neoscrypt   use to mine FeatherCoin, Trezarcoin, Orbitcoin, etc\n                          nist5       use to mine TalkCoin\n                          penta       use to mine Joincoin / Pentablake\n                          phi1612     use to mine Seraph\n                          phi2        use to mine LUXCoin\n                          polytimos   use to mine Polytimos\n                          quark       use to mine Quarkcoin\n                          qubit       use to mine Qubit\n                          scrypt      use to mine Scrypt coins (Litecoin, Dogecoin, etc)\n                          scrypt:N    use to mine Scrypt-N (:10 for 2048 iterations)\n                          scrypt-jane use to mine Chacha coins like Cache and Ultracoin\n                          s3          use to mine 1coin (ONE)\n                          sha256t     use to mine OneCoin (OC)\n                          sia         use to mine SIA\n                          sib         use to mine Sibcoin\n                          skein       use to mine Skeincoin\n                          skein2      use to mine Woodcoin\n                          skunk       use to mine Signatum\n                          sonoa       use to mine Sono\n                          stellite    use to mine Stellite (a cryptonight variant)\n                          timetravel  use to mine MachineCoin\n                          tribus      use to mine Denarius\n                          x11evo      use to mine Revolver\n                          x11         use to mine DarkCoin\n                          x12         use to mine GalaxyCash\n                          x13         use to mine X13\n                          x14         use to mine X14\n                          x15         use to mine Halcyon\n                          x16r        use to mine Raven\n                          x16s        use to mine Pigeon and Eden\n                          x17         use to mine X17\n                          vanilla     use to mine Vanilla (Blake256)\n                          veltor      use to mine VeltorCoin\n                          whirlpool   use to mine Joincoin\n                          wildkeccak  use to mine Boolberry (Stratum only)\n                          zr5         use to mine ZiftrCoin\n\n  -d, --devices         gives a comma separated list of CUDA device IDs\n                        to operate on. Device IDs start counting from 0!\n                        Alternatively give string names of your card like\n                        gtx780ti or gt640#2 (matching 2nd gt640 in the PC).\n\n  -i, --intensity=N[,N] GPU threads per call 8-25 (2^N + F, default: 0=auto)\n                        Decimals and multiple values are allowed for fine tuning\n      --cuda-schedule   Set device threads scheduling mode (default: auto)\n  -f, --diff-factor     Divide difficulty by this factor (default 1.0)\n  -m, --diff-multiplier Multiply difficulty by this value (default 1.0)\n  -o, --url=URL         URL of mining server\n  -O, --userpass=U:P    username:password pair for mining server\n  -u, --user=USERNAME   username for mining server\n  -p, --pass=PASSWORD   password for mining server\n      --cert=FILE       certificate for mining server using SSL\n  -x, --proxy=[PROTOCOL://]HOST[:PORT]  connect through a proxy\n  -t, --threads=N       number of miner threads (default: number of nVidia GPUs in your system)\n  -r, --retries=N       number of times to retry if a network call fails\n                          (default: retry indefinitely)\n  -R, --retry-pause=N   time to pause between retries, in seconds (default: 15)\n      --shares-limit    maximum shares to mine before exiting the program.\n      --time-limit      maximum time [s] to mine before exiting the program.\n  -T, --timeout=N       network timeout, in seconds (default: 300)\n  -s, --scantime=N      upper bound on time spent scanning current work when\n                        long polling is unavailable, in seconds (default: 5)\n      --submit-stale    ignore stale job checks, may create more rejected shares\n  -n, --ndevs           list cuda devices\n  -N, --statsavg        number of samples used to display hashrate (default: 30)\n      --no-gbt          disable getblocktemplate support (height check in solo)\n      --no-longpoll     disable X-Long-Polling support\n      --no-stratum      disable X-Stratum support\n  -q, --quiet           disable per-thread hashmeter output\n      --no-color        disable colored output\n  -D, --debug           enable debug output\n  -P, --protocol-dump   verbose dump of protocol-level activities\n  -b, --api-bind=port   IP:port for the miner API (default: 127.0.0.1:4068), 0 disabled\n      --api-remote      Allow remote control, like pool switching, imply --api-allow=0/0\n      --api-allow=...   IP/mask of the allowed api client(s), 0/0 for all\n      --max-temp=N      Only mine if gpu temp is less than specified value\n      --max-rate=N[KMG] Only mine if net hashrate is less than specified value\n      --max-diff=N      Only mine if net difficulty is less than specified value\n      --max-log-rate    Interval to reduce per gpu hashrate logs (default: 3)\n      --pstate=0        will force the Geforce 9xx to run in P0 P-State\n      --plimit=150W     set the gpu power limit, allow multiple values for N cards\n                          on windows this parameter use percentages (like OC tools)\n      --tlimit=85       Set the gpu thermal limit (windows only)\n      --keep-clocks     prevent reset clocks and/or power limit on exit\n      --hide-diff       Hide submitted shares diff and net difficulty\n  -B, --background      run the miner in the background\n      --benchmark       run in offline benchmark mode\n      --cputest         debug hashes from cpu algorithms\n      --cpu-affinity    set process affinity to specific cpu core(s) mask\n      --cpu-priority    set process priority (default: 0 idle, 2 normal to 5 highest)\n  -c, --config=FILE     load a JSON-format configuration file\n                        can be from an url with the http:// prefix\n  -V, --version         display version information and exit\n  -h, --help            display this help text and exit\n\n\nScrypt specific options:\n  -l, --launch-config   gives the launch configuration for each kernel\n                        in a comma separated list, one per device.\n      --interactive     comma separated list of flags (0/1) specifying\n                        which of the CUDA device you need to run at inter-\n                        active frame rates (because it drives a display).\n  -L, --lookup-gap      Divides the per-hash memory requirement by this factor\n                        by storing only every N'th value in the scratchpad.\n                        Default is 1.\n      --texture-cache   comma separated list of flags (0/1/2) specifying\n                        which of the CUDA devices shall use the texture\n                        cache for mining. Kepler devices may profit.\n      --no-autotune     disable auto-tuning of kernel launch parameters\n\nCryptoNight specific options:\n  -l, --launch-config   gives the launch configuration for each kernel\n                        in a comma separated list, one per device.\n      --bfactor=[0-12]  Run Cryptonight core kernel in smaller pieces,\n                        From 0 (ui freeze) to 12 (smooth), win default is 11\n                        This is a per-device setting like the launch config.\n\nWildkeccak specific:\n  -l, --launch-config   gives the launch configuration for each kernel\n                        in a comma separated list, one per device.\n  -k, --scratchpad url  Url used to download the scratchpad cache.\n\n\n  \n------------------------------CryptoDredge-----------------------------------------------------------\nCOMMAND-LINE ARGUMENTS\n\n  -v, --version       Print version information\n  -a, --algo          Specify algorithm to use\n                      allium\n                      blake2s\n                      lyra2v2\n                      lyra2v2-old (see the \"Lyra2REv2 Issues\" item)\n                      lyra2z\n                      neoscrypt\n                      phi\n                      phi2\n                      skein\n                      skunk\n  -d, --device        List of comma-separated device IDs to use for mining.\n                      IDs are numbered 0,1...,N - 1\n  -h, --help          Print help information\n  -i, --intensity     Mining intensity (0 - 6) (default: 6)\n  -o, --url           URL of mining pool\n  -p, --pass          Password/Options for mining pool\n  -u, --user          Username for mining pool\n      --log           Log output to file\n      --no-color      Force color off\n      --no-watchdog   Force watchdog off\n      --cpu-priority  Set process priority in the range 0 (low) to 5 (high)\n                      (default: 3)\n      --api-type      Specify API type to use\n                      ccminer-tcp (TCP)\n                      ccminer-ws (WebSocket)\n                      off\n                      (default: ccminer-tcp)\n  -b, --api-bind      IP:port for the miner API, 0 disabled\n                      (default: 127.0.0.1:4068)\n      --retries       N number of times to retry if a network call fails\n                      (default: retry indefinitely)\n      --retry-pause   N time to pause between retries, in seconds (default: 15)\n      --timeout       N network timeout, in seconds (default: 30)\n\n\n\n------------------------------Z-Enemy----------------------------------------------------------------\nOptions:\n  -a, --algo=ALGO         Coin hash algorithm to use:\n\t\t\t\t\taeriumx\t\t(AeriumX: AEX)\n\t\t\t\t\tbitcore\t\t(Bitcore: BTX)\n\t\t\t\t\tx16r\t\t(X16R: Raven)\n\t\t\t\t\tx16s\t\t(X16S: Pigeon)\n\t\t\t\t\tx17\t\t(X17: Verge)\n\t\t\t\t\tc11\t\t(C11: CHC)\n\t\t\t\t\tphi\t\t(PHI1612: Phi)\n\t\t\t\t\tphi2\t\t(PHI2: LUXCoin)\n\t\t\t\t\ttribus\t\t(Tribus: Denarius)\n\t\t\t\t\tpoly\t\t(Poly: Polytimos)\n\t\t\t\t\tskunk\t\t(Skunk: Skunk)\n\t\t\t\t\tsonoax\t\t(Sonoa: SONO)\n\t\t\t\t\ttimetravel\t(Machinecoin: MAC)\n\t\t\t\t\txevan\t\t(Xevan: Transend)\n  -d, --devices           Comma separated list of CUDA devices to use (0,1 etc).\n                          Alternatively takes\n                          string names of your cards like MSI 1080 Ti or MX150#2\n                          (matching 2nd gt640 in the PC)\n  -i  --intensity=N[,N]   GPU intensity 8.0-31.0, decimals allowed (default: 19) \n      --cuda-schedule     set CUDA scheduling option:\n\t                         0: BlockingSync (default)\n\t                         1: Spin\n\t                         2: Yield\n  -f, --diff-factor       Divide difficulty by this factor (default 1.0) \n  -l, --log=FILE          Duplicate output into log file. Sample: --log=logfile.txt\n  -m, --diff-multiplier   Multiply difficulty by this value (default 1.0) \n  -o, --url=URL           URL of mining server\n  -O, --userpass=U:P      username:password pair for mining server\n  -u, --user=USERNAME     username for mining server\n  -p, --pass=PASSWORD     password for mining server\n      --cert=FILE         certificate for mining server using SSL\n  -x, --proxy=[PROTOCOL://]HOST[:PORT]  connect through a proxy\n  -t, --threads=N         number of miner threads (default: number of nVidia GPUs)\n  -r, --retries=N         number of times to retry if a network call fails\n                          (default: retry indefinitely)\n  -R, --retry-pause=N     time to pause between retries, in seconds (default: 30)\n  -T, --timeout=N         network timeout, in seconds (default: 300)\n  -s, --scantime=N        upper bound on time spent scanning current work when\n                          long polling is unavailable, in seconds (default: 60)\n  -n, --ndevs             list cuda devices\n  -N, --statsavg          number of samples used to compute hashrate (default: 30)\n      --no-extranonce     disable extranonce subscribe on stratum\n  -q, --quiet             disable per-thread hashmeter output\n      --no-color          disable colored output\n      --cpu-affinity      set process affinity to cpu core(s), mask 0x3 for cores 0 and 1\n      --cpu-priority      set process priority (default: 3) 0 idle, 2 normal to 5 highest\n  -b, --api-bind=port     IP:port for the miner API (default: 127.0.0.1:4068), 0 disabled\n      --api-allow=...     IP/mask of the allowed api client(s), 0/0 for all\n      --api-remote        Allow remote control, like pool switching\n      --mem-clock=3505    Set the gpu memory boost clock\n      --gpu-clock=1150    Set the gpu engine boost clock\n      --plimit=100        Set the gpu power limit in percentage\n      --tlimit=80         Set the gpu thermal limit in degrees\n  -B, --background        run the miner in the background\n  -c, --config=FILE       load a JSON-format configuration file Sample: --config=config.json\n  -V, --version           display version information and exit\n  -h, --help              display this help text and exit\n\n");
        HelpTextArea.setCaretPosition(0);
        HelpScrollPane.setViewportView(HelpTextArea);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(HelpScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 971, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(HelpScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
        );

        Tabs.addTab("Help", jPanel6);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Tabs)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Tabs)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    private void StartMinerButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	Wrapper.setDevices(GPUsAvailableList.getSelectedIndices());
    	Wrapper.setAlgo(AlgorithmCombobox.getSelectedItem().toString());
    	Wrapper.setPoolURL(PoolURLTextInput.getText());
    	Wrapper.setUsername(UsernameTextInput.getText());
    	Wrapper.setPassword(PasswordTextInput.getText());
        Wrapper.setAdvCMDText(AdvancedCommandlineTextInput.getText());
    	
        if(Wrapper.isMinerRunning())
    	{
        	Wrapper.stopMiner();
    	}
        else if(Wrapper.checkReady())
        {
        	Wrapper.startMiner();
        }
    	else
    	{
    		JOptionPane.showMessageDialog(this,"You must fill in all required fields before starting the miner!");
    	}
    }


    // Variables declaration - do not modify                     
    private javax.swing.JTextField AdvancedCommandlineTextInput;
    private javax.swing.JComboBox<String> AlgorithmCombobox;
    private javax.swing.JTextField AlgorithmField;
    private javax.swing.JTextField AvgTempField;
    private javax.swing.JTextArea ConsoleTextArea;
    private javax.swing.JList<String> GPUsAvailableList;
    private javax.swing.JList<String> GPUsIntensityList;
    private javax.swing.JScrollPane HelpScrollPane;
    private javax.swing.JTextArea HelpTextArea;
    private javax.swing.JPanel MonitorPane;
    private javax.swing.JTextField PasswordTextInput;
    private javax.swing.JTextField PoolURLTextInput;
    private javax.swing.JButton StartMinerButton;
    private javax.swing.JTabbedPane Tabs;
    private javax.swing.JTextField TotalGPUsHashingField;
    private javax.swing.JTextField TotalHashrateField;
    private javax.swing.JTextField UsernameTextInput;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JSplitPane jSplitPane3;
    private javax.swing.JSplitPane jSplitPane4;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration           
    
}