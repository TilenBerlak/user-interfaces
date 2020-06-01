/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naloga4;

import java.io.File;
import java.io.FileWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author tilen
 */
public class MainForm extends javax.swing.JFrame {

    private String creditCardNumber = "";
    private int majhnaCena = 70;
    private int srednjaCena = 100;
    private int visokaCena = 140;
    private boolean dodatnoZavarovanje = true;
    
    
    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
        fillDays();
        fillMonths();
        fillHours();
        fillCars();
        updateCena(100);
    }
    
    /**
     * Fills both comboBoxes with days from 1 to 31.
     */
    private void fillDays() {
        
        for(int i = 1; i <= 31; i++) {
            jComboBoxIzposojaDan.addItem(Integer.toString(i));
            jComboBoxOddajaDan.addItem(Integer.toString(i));
        }
    }
    
    /**
     * Fills both comboBoxes with months from January to February.
     */
    private void fillMonths() {
        String[] months = {"januar", "februar", "marec", "april", "maj", "junij",
            "julij", "august", "september", "oktober", "november", "december"};
        
        for(String e : months) {
            jComboBoxIzposojaMesec.addItem(e);
            jComboBoxOddajaMesec.addItem(e);
        }
    }
    
    /**
     * Fills both comboBoxes with hours from 00:00 to 23:00.
     */
    private void fillHours() {
        
        for(int i = 0; i < 24; i++) {
            String hour;
            
            if (i < 10) {
                hour = "0" + i + ".00";
            } else {
                hour = i + ".00";
            }
            
            jComboBoxIzposojaUra.addItem(hour);
            jComboBoxOddajaUra.addItem(hour);
        }
        
    }
     
    private void fillCars() {
        
        jComboBoxIzbiraAvtomobila.removeAllItems();
        
        String[] smallCars = {"Hyundai i20", "Škoda Fabia", "Toyota Yairs", "Renault Clio"};
        String[] mediumCars = {"MB C180", "Audi A5", "Toyota Avensis", "Honda Accord", "Škoda Octavia"};
        String[] largeCars = {"BMW Serija 7", "Audi Q7", "Chevrolet Blazer", "Dodge Durango", "Škoda Superb"};
        
        if (jRadioButtonVelikostMajhen.isSelected()) {
            
            for(int i = 0; i < smallCars.length; i++) {
                jComboBoxIzbiraAvtomobila.addItem(smallCars[i]);
            }
            
        } else if (jRadioButtonVelikostSrednji.isSelected()) {
            
            for(int i = 0; i < mediumCars.length; i++) {           
                jComboBoxIzbiraAvtomobila.addItem(mediumCars[i]);         
            }   
            
        } else {
            
            for(int i = 0; i < largeCars.length; i++) {
                jComboBoxIzbiraAvtomobila.addItem(largeCars[i]);
            } 
            
        }      
    }
    
    private int calculateNumberOfDays() {
        
        int danIzposoje = jComboBoxIzposojaDan.getSelectedIndex();
        int danOddaje = jComboBoxOddajaDan.getSelectedIndex();
        
        int mesecIzposoje = jComboBoxIzposojaMesec.getSelectedIndex();
        int mesecOddaje = jComboBoxOddajaMesec.getSelectedIndex();
        
        int steviloDni = (danOddaje - danIzposoje) + 1;
        int steviloDniOriginal = steviloDni;
        int steviloMesecev = mesecOddaje - mesecIzposoje;
        
        if (steviloDni < 0) {
            steviloDni = Math.abs(steviloDni);
        } else if (steviloDni == 0) {
            steviloDni = 1;
        }
        
        int vsiDnevi;
        if (steviloMesecev > 0) {
            
            vsiDnevi = (30 * steviloMesecev) + steviloDni; 
            
        } else if (steviloMesecev < 0 || (steviloMesecev == 0 && steviloDniOriginal < 0)) {
            steviloMesecev = Math.abs(steviloMesecev);
            
            vsiDnevi = 30 * (12 - steviloMesecev) + steviloDni;
            
        } else {
            vsiDnevi = steviloDni;
        }
        
        return vsiDnevi;
    }
    
    private int calculateDnevnaCena(int cena) {
        
        int dnevnaCena = cena;
        
        if (jRadioButtonDodatnoDa.isSelected())        
            dnevnaCena += 2;
               
        return dnevnaCena;
    }
    
    private int calculateSkupnaCena(int cena) {
        
        int vsiDnevi = calculateNumberOfDays();
        int skupnaCena = vsiDnevi * cena;
        return skupnaCena;
    }
    
    private void updateCena(int cena) {
        
        int dnevnaCena = calculateDnevnaCena(cena);
        int skupnaCena = calculateSkupnaCena(dnevnaCena); 
        jLabelDnevnaNajemnina.setText(Integer.toString(dnevnaCena));
        jLabelSkupnaNajemnina.setText(Integer.toString(skupnaCena)); 
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupVelikostAvtomobila = new javax.swing.ButtonGroup();
        buttonGroupIzbiraMenjalnika = new javax.swing.ButtonGroup();
        buttonGroupVrstaMotorja = new javax.swing.ButtonGroup();
        buttonGroupDodatnoZavarovanje = new javax.swing.ButtonGroup();
        buttonGroupMoznostPlacila = new javax.swing.ButtonGroup();
        jFileChooser = new javax.swing.JFileChooser();
        jPanelMain = new javax.swing.JPanel();
        jLayeredPaneAvtomobil = new javax.swing.JLayeredPane();
        jLabelDatumIzposoje = new javax.swing.JLabel();
        jLabelDatumOddaje = new javax.swing.JLabel();
        jLabelPrevzemnoMesto = new javax.swing.JLabel();
        jLabelMestoOddaje = new javax.swing.JLabel();
        jLabelVelikostAvtomobila = new javax.swing.JLabel();
        jComboBoxPrevzemnoMesto = new javax.swing.JComboBox<>();
        jComboBoxMestoOddaje = new javax.swing.JComboBox<>();
        jRadioButtonVelikostMajhen = new javax.swing.JRadioButton();
        jRadioButtonVelikostSrednji = new javax.swing.JRadioButton();
        jRadioButtonVelikostVelik = new javax.swing.JRadioButton();
        jLabelIzbiraAvtomobila = new javax.swing.JLabel();
        jComboBoxIzbiraAvtomobila = new javax.swing.JComboBox<>();
        jLabelIzbiraMenjalnika = new javax.swing.JLabel();
        jLabelVrstaMotorja = new javax.swing.JLabel();
        jComboBoxIzposojaDan = new javax.swing.JComboBox<>();
        jRadioButtonMenjalnikSamodejni = new javax.swing.JRadioButton();
        jRadioButtonMenjalnikRočni = new javax.swing.JRadioButton();
        jRadioButtonMotorDizelski = new javax.swing.JRadioButton();
        jRadioButtonMotorBencinski = new javax.swing.JRadioButton();
        jComboBoxIzposojaMesec = new javax.swing.JComboBox<>();
        jComboBoxIzposojaUra = new javax.swing.JComboBox<>();
        jComboBoxOddajaDan = new javax.swing.JComboBox<>();
        jComboBoxOddajaMesec = new javax.swing.JComboBox<>();
        jComboBoxOddajaUra = new javax.swing.JComboBox<>();
        jLayeredPaneOseba = new javax.swing.JLayeredPane();
        jLabelImeOsebe = new javax.swing.JLabel();
        jLabelPriimekOsebe = new javax.swing.JLabel();
        jTextFieldIme = new javax.swing.JTextField();
        jTextFieldPriimek = new javax.swing.JTextField();
        jLabelKrajOsebe = new javax.swing.JLabel();
        jLabelUlicaOsebe = new javax.swing.JLabel();
        jLabelTelefonOsebe = new javax.swing.JLabel();
        jTextFieldTelefon = new javax.swing.JTextField();
        jLabelStarostOsebe = new javax.swing.JLabel();
        jLabelDodatnoZav = new javax.swing.JLabel();
        jRadioButtonDodatnoDa = new javax.swing.JRadioButton();
        jRadioButtonDodatnoNe = new javax.swing.JRadioButton();
        jSpinnerStarost = new javax.swing.JSpinner();
        jTextFieldKraj = new javax.swing.JTextField();
        jTextFieldUlica = new javax.swing.JTextField();
        jLabelPostnaSt = new javax.swing.JLabel();
        jTextFieldPostnaSt = new javax.swing.JTextField();
        jLabelEposta = new javax.swing.JLabel();
        jTextFieldEposta = new javax.swing.JTextField();
        jLabelIzkusnje = new javax.swing.JLabel();
        jSpinnerIzkusnje = new javax.swing.JSpinner();
        jLayeredPanePlačilo = new javax.swing.JLayeredPane();
        jLabelMoznostPlacila = new javax.swing.JLabel();
        jRadioButtonGotovina = new javax.swing.JRadioButton();
        jRadioButtonKartica = new javax.swing.JRadioButton();
        jButtonIzvediPlacilo = new javax.swing.JButton();
        jLabelStKartice = new javax.swing.JLabel();
        jLabelCCV = new javax.swing.JLabel();
        jTextFieldCCV = new javax.swing.JTextField();
        jLayeredPaneZnesek = new javax.swing.JLayeredPane();
        jLabelDnesvniZnesek = new javax.swing.JLabel();
        jLabelSkupniZnesek = new javax.swing.JLabel();
        jLabelDnevnaNajemnina = new javax.swing.JLabel();
        jLabelSkupnaNajemnina = new javax.swing.JLabel();
        jButtonPonastavi = new javax.swing.JButton();
        jButtonShrani = new javax.swing.JButton();
        jPasswordFieldStKartice = new javax.swing.JPasswordField();
        jLabelStatus = new javax.swing.JLabel();
        jMenuBarMain = new javax.swing.JMenuBar();
        jMenuDatoteka = new javax.swing.JMenu();
        jMenuItemOdpri = new javax.swing.JMenuItem();
        jMenuItemShrani = new javax.swing.JMenuItem();
        jMenuItemIzhod = new javax.swing.JMenuItem();
        jMenuUredi = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuPomoc = new javax.swing.JMenu();
        jMenuItemAvtor = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Izposojevalnica avtomobilov Avtek");

        jPanelMain.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        jLayeredPaneAvtomobil.setBorder(javax.swing.BorderFactory.createTitledBorder("Podatki o avtomobilu"));
        jLayeredPaneAvtomobil.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        jLabelDatumIzposoje.setText("Datum izposoje:");

        jLabelDatumOddaje.setText("Datum oddaje:");

        jLabelPrevzemnoMesto.setText("Prevzemno mesto:");

        jLabelMestoOddaje.setText("Mesto oddaje:");

        jLabelVelikostAvtomobila.setText("Velikost avtomobila:");

        jComboBoxPrevzemnoMesto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ljubljana", "Maribor", "Celje", "Kranj", "Velenje", "Koper", "Novo Mesto", "Murska Sobota", "Jesenice", "Portorož", "letališče Brnik", "letačišče Maribor" }));

        jComboBoxMestoOddaje.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ljubljana", "Maribor", "Celje", "Kranj", "Velenje", "Koper", "Novo Mesto", "Murska Sobota", "Jesenice", "Portorož", "letališče Brnik", "letačišče Maribor" }));

        buttonGroupVelikostAvtomobila.add(jRadioButtonVelikostMajhen);
        jRadioButtonVelikostMajhen.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jRadioButtonVelikostMajhen.setText("Majhen");
        jRadioButtonVelikostMajhen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smallCarSizeSelected(evt);
            }
        });

        buttonGroupVelikostAvtomobila.add(jRadioButtonVelikostSrednji);
        jRadioButtonVelikostSrednji.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jRadioButtonVelikostSrednji.setSelected(true);
        jRadioButtonVelikostSrednji.setText("Srednji");
        jRadioButtonVelikostSrednji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mediumCarSizeSelected(evt);
            }
        });

        buttonGroupVelikostAvtomobila.add(jRadioButtonVelikostVelik);
        jRadioButtonVelikostVelik.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jRadioButtonVelikostVelik.setText("Velik");
        jRadioButtonVelikostVelik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                largeCarSizeSelected(evt);
            }
        });

        jLabelIzbiraAvtomobila.setText("Izbira avtomobila:");

        jLabelIzbiraMenjalnika.setText("Izbira menjalnika:");

        jLabelVrstaMotorja.setText("Vrsta motorja:");

        jComboBoxIzposojaDan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateChanged(evt);
            }
        });

        buttonGroupIzbiraMenjalnika.add(jRadioButtonMenjalnikSamodejni);
        jRadioButtonMenjalnikSamodejni.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jRadioButtonMenjalnikSamodejni.setText("Samodejni");

        buttonGroupIzbiraMenjalnika.add(jRadioButtonMenjalnikRočni);
        jRadioButtonMenjalnikRočni.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jRadioButtonMenjalnikRočni.setSelected(true);
        jRadioButtonMenjalnikRočni.setText("Ročni");

        buttonGroupVrstaMotorja.add(jRadioButtonMotorDizelski);
        jRadioButtonMotorDizelski.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jRadioButtonMotorDizelski.setText("Dizelski");
        jRadioButtonMotorDizelski.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMotorDizelskiActionPerformed(evt);
            }
        });

        buttonGroupVrstaMotorja.add(jRadioButtonMotorBencinski);
        jRadioButtonMotorBencinski.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jRadioButtonMotorBencinski.setSelected(true);
        jRadioButtonMotorBencinski.setText("Bencinski");

        jComboBoxIzposojaMesec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateChanged(evt);
            }
        });

        jComboBoxIzposojaUra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateChanged(evt);
            }
        });

        jComboBoxOddajaDan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateChanged(evt);
            }
        });

        jComboBoxOddajaMesec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateChanged(evt);
            }
        });

        jComboBoxOddajaUra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateChanged(evt);
            }
        });

        jLayeredPaneAvtomobil.setLayer(jLabelDatumIzposoje, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPaneAvtomobil.setLayer(jLabelDatumOddaje, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPaneAvtomobil.setLayer(jLabelPrevzemnoMesto, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPaneAvtomobil.setLayer(jLabelMestoOddaje, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPaneAvtomobil.setLayer(jLabelVelikostAvtomobila, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPaneAvtomobil.setLayer(jComboBoxPrevzemnoMesto, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPaneAvtomobil.setLayer(jComboBoxMestoOddaje, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPaneAvtomobil.setLayer(jRadioButtonVelikostMajhen, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPaneAvtomobil.setLayer(jRadioButtonVelikostSrednji, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPaneAvtomobil.setLayer(jRadioButtonVelikostVelik, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPaneAvtomobil.setLayer(jLabelIzbiraAvtomobila, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPaneAvtomobil.setLayer(jComboBoxIzbiraAvtomobila, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPaneAvtomobil.setLayer(jLabelIzbiraMenjalnika, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPaneAvtomobil.setLayer(jLabelVrstaMotorja, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPaneAvtomobil.setLayer(jComboBoxIzposojaDan, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPaneAvtomobil.setLayer(jRadioButtonMenjalnikSamodejni, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPaneAvtomobil.setLayer(jRadioButtonMenjalnikRočni, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPaneAvtomobil.setLayer(jRadioButtonMotorDizelski, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPaneAvtomobil.setLayer(jRadioButtonMotorBencinski, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPaneAvtomobil.setLayer(jComboBoxIzposojaMesec, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPaneAvtomobil.setLayer(jComboBoxIzposojaUra, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPaneAvtomobil.setLayer(jComboBoxOddajaDan, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPaneAvtomobil.setLayer(jComboBoxOddajaMesec, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPaneAvtomobil.setLayer(jComboBoxOddajaUra, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPaneAvtomobilLayout = new javax.swing.GroupLayout(jLayeredPaneAvtomobil);
        jLayeredPaneAvtomobil.setLayout(jLayeredPaneAvtomobilLayout);
        jLayeredPaneAvtomobilLayout.setHorizontalGroup(
            jLayeredPaneAvtomobilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPaneAvtomobilLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPaneAvtomobilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPaneAvtomobilLayout.createSequentialGroup()
                        .addComponent(jLabelIzbiraAvtomobila)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jLayeredPaneAvtomobilLayout.createSequentialGroup()
                        .addGroup(jLayeredPaneAvtomobilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPaneAvtomobilLayout.createSequentialGroup()
                                .addComponent(jLabelDatumIzposoje, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                                .addGap(262, 262, 262))
                            .addGroup(jLayeredPaneAvtomobilLayout.createSequentialGroup()
                                .addGroup(jLayeredPaneAvtomobilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jLayeredPaneAvtomobilLayout.createSequentialGroup()
                                        .addComponent(jLabelPrevzemnoMesto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(30, 30, 30))
                                    .addGroup(jLayeredPaneAvtomobilLayout.createSequentialGroup()
                                        .addComponent(jLabelVelikostAvtomobila)
                                        .addGap(18, 18, 18)))
                                .addGroup(jLayeredPaneAvtomobilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jLayeredPaneAvtomobilLayout.createSequentialGroup()
                                        .addComponent(jComboBoxIzposojaDan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBoxIzposojaMesec, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBoxIzposojaUra, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jLayeredPaneAvtomobilLayout.createSequentialGroup()
                                        .addComponent(jComboBoxPrevzemnoMesto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(78, 78, 78))
                                    .addGroup(jLayeredPaneAvtomobilLayout.createSequentialGroup()
                                        .addComponent(jRadioButtonVelikostMajhen)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jRadioButtonVelikostSrednji, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jRadioButtonVelikostVelik, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(28, 28, 28))
                                    .addGroup(jLayeredPaneAvtomobilLayout.createSequentialGroup()
                                        .addComponent(jComboBoxIzbiraAvtomobila, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(79, 79, 79)))))
                        .addGap(62, 62, 62)
                        .addGroup(jLayeredPaneAvtomobilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPaneAvtomobilLayout.createSequentialGroup()
                                .addGroup(jLayeredPaneAvtomobilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelIzbiraMenjalnika, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                    .addGroup(jLayeredPaneAvtomobilLayout.createSequentialGroup()
                                        .addComponent(jLabelMestoOddaje)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jLabelDatumOddaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jLayeredPaneAvtomobilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jLayeredPaneAvtomobilLayout.createSequentialGroup()
                                        .addComponent(jComboBoxMestoOddaje, 0, 195, Short.MAX_VALUE)
                                        .addGap(113, 113, 113))
                                    .addGroup(jLayeredPaneAvtomobilLayout.createSequentialGroup()
                                        .addComponent(jComboBoxOddajaDan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jComboBoxOddajaMesec, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBoxOddajaUra, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(35, 35, 35))
                                    .addGroup(jLayeredPaneAvtomobilLayout.createSequentialGroup()
                                        .addGroup(jLayeredPaneAvtomobilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jRadioButtonMenjalnikRočni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jRadioButtonMotorDizelski, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jLayeredPaneAvtomobilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jLayeredPaneAvtomobilLayout.createSequentialGroup()
                                                .addComponent(jRadioButtonMotorBencinski, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addContainerGap())
                                            .addGroup(jLayeredPaneAvtomobilLayout.createSequentialGroup()
                                                .addComponent(jRadioButtonMenjalnikSamodejni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(35, 35, 35))))))
                            .addGroup(jLayeredPaneAvtomobilLayout.createSequentialGroup()
                                .addComponent(jLabelVrstaMotorja)
                                .addContainerGap())))))
        );
        jLayeredPaneAvtomobilLayout.setVerticalGroup(
            jLayeredPaneAvtomobilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPaneAvtomobilLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPaneAvtomobilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDatumIzposoje)
                    .addComponent(jComboBoxIzposojaDan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxIzposojaMesec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxIzposojaUra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxOddajaDan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxOddajaMesec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxOddajaUra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDatumOddaje))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jLayeredPaneAvtomobilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPrevzemnoMesto)
                    .addComponent(jComboBoxPrevzemnoMesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMestoOddaje)
                    .addComponent(jComboBoxMestoOddaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jLayeredPaneAvtomobilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPaneAvtomobilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelVrstaMotorja)
                        .addComponent(jRadioButtonMotorDizelski)
                        .addComponent(jRadioButtonMotorBencinski))
                    .addGroup(jLayeredPaneAvtomobilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelVelikostAvtomobila)
                        .addComponent(jRadioButtonVelikostMajhen)
                        .addComponent(jRadioButtonVelikostSrednji)
                        .addComponent(jRadioButtonVelikostVelik)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jLayeredPaneAvtomobilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPaneAvtomobilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelIzbiraAvtomobila)
                        .addComponent(jComboBoxIzbiraAvtomobila, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPaneAvtomobilLayout.createSequentialGroup()
                        .addGroup(jLayeredPaneAvtomobilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelIzbiraMenjalnika)
                            .addComponent(jRadioButtonMenjalnikRočni)
                            .addComponent(jRadioButtonMenjalnikSamodejni))
                        .addGap(4, 4, 4)))
                .addContainerGap())
        );

        jLayeredPaneOseba.setBorder(javax.swing.BorderFactory.createTitledBorder("Podatki o osebi"));
        jLayeredPaneOseba.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        jLabelImeOsebe.setText("Ime:");

        jLabelPriimekOsebe.setText("Priimek:");

        jLabelKrajOsebe.setText("Kraj:");

        jLabelUlicaOsebe.setText("Ulica:");

        jLabelTelefonOsebe.setText("Telefon:");

        jLabelStarostOsebe.setText("Starost:");

        jLabelDodatnoZav.setText("Dodatno zavarovanje:");

        buttonGroupDodatnoZavarovanje.add(jRadioButtonDodatnoDa);
        jRadioButtonDodatnoDa.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jRadioButtonDodatnoDa.setSelected(true);
        jRadioButtonDodatnoDa.setText("Da");
        jRadioButtonDodatnoDa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dodatnoZavarovanjeSelected(evt);
            }
        });

        buttonGroupDodatnoZavarovanje.add(jRadioButtonDodatnoNe);
        jRadioButtonDodatnoNe.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jRadioButtonDodatnoNe.setText("Ne");
        jRadioButtonDodatnoNe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dodatnoZavarovanjeDiselected(evt);
            }
        });

        jSpinnerStarost.setModel(new javax.swing.SpinnerNumberModel(21, 18, 130, 1));

        jLabelPostnaSt.setText("Poštna št.:");

        jTextFieldPostnaSt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                preveriPostnaSt(evt);
            }
        });

        jLabelEposta.setText("E-pošta:");

        jTextFieldEposta.setToolTipText("");

        jLabelIzkusnje.setText("Izkušnje(leta):");

        jSpinnerIzkusnje.setModel(new javax.swing.SpinnerNumberModel(0, 0, 110, 1));

        jLayeredPaneOseba.setLayer(jLabelImeOsebe, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPaneOseba.setLayer(jLabelPriimekOsebe, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPaneOseba.setLayer(jTextFieldIme, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPaneOseba.setLayer(jTextFieldPriimek, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPaneOseba.setLayer(jLabelKrajOsebe, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPaneOseba.setLayer(jLabelUlicaOsebe, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPaneOseba.setLayer(jLabelTelefonOsebe, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPaneOseba.setLayer(jTextFieldTelefon, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPaneOseba.setLayer(jLabelStarostOsebe, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPaneOseba.setLayer(jLabelDodatnoZav, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPaneOseba.setLayer(jRadioButtonDodatnoDa, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPaneOseba.setLayer(jRadioButtonDodatnoNe, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPaneOseba.setLayer(jSpinnerStarost, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPaneOseba.setLayer(jTextFieldKraj, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPaneOseba.setLayer(jTextFieldUlica, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPaneOseba.setLayer(jLabelPostnaSt, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPaneOseba.setLayer(jTextFieldPostnaSt, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPaneOseba.setLayer(jLabelEposta, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPaneOseba.setLayer(jTextFieldEposta, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPaneOseba.setLayer(jLabelIzkusnje, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPaneOseba.setLayer(jSpinnerIzkusnje, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPaneOsebaLayout = new javax.swing.GroupLayout(jLayeredPaneOseba);
        jLayeredPaneOseba.setLayout(jLayeredPaneOsebaLayout);
        jLayeredPaneOsebaLayout.setHorizontalGroup(
            jLayeredPaneOsebaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPaneOsebaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPaneOsebaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPaneOsebaLayout.createSequentialGroup()
                        .addComponent(jLabelDodatnoZav)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButtonDodatnoDa)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButtonDodatnoNe)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jLayeredPaneOsebaLayout.createSequentialGroup()
                        .addGroup(jLayeredPaneOsebaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPaneOsebaLayout.createSequentialGroup()
                                .addComponent(jLabelImeOsebe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(1, 1, 1))
                            .addGroup(jLayeredPaneOsebaLayout.createSequentialGroup()
                                .addComponent(jLabelUlicaOsebe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(2, 2, 2))
                            .addComponent(jLabelTelefonOsebe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(47, 47, 47)
                        .addGroup(jLayeredPaneOsebaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPaneOsebaLayout.createSequentialGroup()
                                .addComponent(jTextFieldUlica)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jLayeredPaneOsebaLayout.createSequentialGroup()
                                .addComponent(jTextFieldTelefon)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 193, Short.MAX_VALUE))
                            .addGroup(jLayeredPaneOsebaLayout.createSequentialGroup()
                                .addComponent(jTextFieldIme, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jLayeredPaneOsebaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPaneOsebaLayout.createSequentialGroup()
                                .addComponent(jLabelKrajOsebe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(30, 30, 30))
                            .addGroup(jLayeredPaneOsebaLayout.createSequentialGroup()
                                .addComponent(jLabelEposta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(23, 23, 23))
                            .addComponent(jLabelPriimekOsebe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jLayeredPaneOsebaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPaneOsebaLayout.createSequentialGroup()
                                .addComponent(jTextFieldKraj)
                                .addGap(7, 7, 7))
                            .addGroup(jLayeredPaneOsebaLayout.createSequentialGroup()
                                .addComponent(jTextFieldEposta)
                                .addGap(13, 13, 13))
                            .addComponent(jTextFieldPriimek))
                        .addGap(107, 107, 107)
                        .addGroup(jLayeredPaneOsebaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPaneOsebaLayout.createSequentialGroup()
                                .addComponent(jLabelIzkusnje, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSpinnerIzkusnje))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPaneOsebaLayout.createSequentialGroup()
                                .addGroup(jLayeredPaneOsebaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelStarostOsebe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jLayeredPaneOsebaLayout.createSequentialGroup()
                                        .addComponent(jLabelPostnaSt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(4, 4, 4)))
                                .addGap(16, 16, 16)
                                .addGroup(jLayeredPaneOsebaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jLayeredPaneOsebaLayout.createSequentialGroup()
                                        .addComponent(jTextFieldPostnaSt)
                                        .addGap(3, 3, 3))
                                    .addComponent(jSpinnerStarost))))
                        .addGap(199, 199, 199))))
        );
        jLayeredPaneOsebaLayout.setVerticalGroup(
            jLayeredPaneOsebaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPaneOsebaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jLayeredPaneOsebaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPaneOsebaLayout.createSequentialGroup()
                        .addComponent(jTextFieldIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jLayeredPaneOsebaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldUlica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelUlicaOsebe))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jLayeredPaneOsebaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelTelefonOsebe)))
                    .addGroup(jLayeredPaneOsebaLayout.createSequentialGroup()
                        .addComponent(jTextFieldPriimek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jLayeredPaneOsebaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldKraj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPostnaSt)
                            .addComponent(jTextFieldPostnaSt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jLayeredPaneOsebaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldEposta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelIzkusnje)
                            .addComponent(jSpinnerIzkusnje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jLayeredPaneOsebaLayout.createSequentialGroup()
                        .addComponent(jLabelPriimekOsebe)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(jLabelKrajOsebe)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(jLabelEposta))
                    .addGroup(jLayeredPaneOsebaLayout.createSequentialGroup()
                        .addGroup(jLayeredPaneOsebaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelImeOsebe)
                            .addGroup(jLayeredPaneOsebaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jSpinnerStarost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelStarostOsebe)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(9, 9, 9)
                .addGroup(jLayeredPaneOsebaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDodatnoZav)
                    .addComponent(jRadioButtonDodatnoDa)
                    .addComponent(jRadioButtonDodatnoNe)))
        );

        jLayeredPanePlačilo.setBorder(javax.swing.BorderFactory.createTitledBorder("Plačilo"));
        jLayeredPanePlačilo.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        jLabelMoznostPlacila.setText("Možnost plačila:");

        buttonGroupMoznostPlacila.add(jRadioButtonGotovina);
        jRadioButtonGotovina.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jRadioButtonGotovina.setText("Gotovina");
        jRadioButtonGotovina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gotovinaSelected(evt);
            }
        });

        buttonGroupMoznostPlacila.add(jRadioButtonKartica);
        jRadioButtonKartica.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jRadioButtonKartica.setSelected(true);
        jRadioButtonKartica.setText("Kartica");
        jRadioButtonKartica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                karticaSelected(evt);
            }
        });

        jButtonIzvediPlacilo.setText("Izvedi plačilo");
        jButtonIzvediPlacilo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                izvediPlacilo(evt);
            }
        });

        jLabelStKartice.setText("Št. kreditne kartice:");

        jLabelCCV.setText("CCV:");

        jLayeredPaneZnesek.setBorder(javax.swing.BorderFactory.createTitledBorder("Plačilni znesek"));

        jLabelDnesvniZnesek.setText("Dnevni znesek:");

        jLabelSkupniZnesek.setText("Skupni znesek:");

        jLabelDnevnaNajemnina.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N

        jLabelSkupnaNajemnina.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N

        jLayeredPaneZnesek.setLayer(jLabelDnesvniZnesek, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPaneZnesek.setLayer(jLabelSkupniZnesek, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPaneZnesek.setLayer(jLabelDnevnaNajemnina, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPaneZnesek.setLayer(jLabelSkupnaNajemnina, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPaneZnesekLayout = new javax.swing.GroupLayout(jLayeredPaneZnesek);
        jLayeredPaneZnesek.setLayout(jLayeredPaneZnesekLayout);
        jLayeredPaneZnesekLayout.setHorizontalGroup(
            jLayeredPaneZnesekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPaneZnesekLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPaneZnesekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDnesvniZnesek, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jLayeredPaneZnesekLayout.createSequentialGroup()
                        .addComponent(jLabelSkupniZnesek, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(2, 2, 2)))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPaneZnesekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelSkupnaNajemnina)
                    .addComponent(jLabelDnevnaNajemnina))
                .addGap(262, 262, 262))
        );
        jLayeredPaneZnesekLayout.setVerticalGroup(
            jLayeredPaneZnesekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPaneZnesekLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPaneZnesekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDnesvniZnesek)
                    .addComponent(jLabelDnevnaNajemnina))
                .addGap(40, 40, 40)
                .addGroup(jLayeredPaneZnesekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSkupniZnesek)
                    .addComponent(jLabelSkupnaNajemnina))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jButtonPonastavi.setText("Izbriši vnos");
        jButtonPonastavi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetValues(evt);
            }
        });

        jButtonShrani.setText("Shrani vnos");
        jButtonShrani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shraniVnos(evt);
            }
        });

        jPasswordFieldStKartice.setEchoChar('x');

        jLayeredPanePlačilo.setLayer(jLabelMoznostPlacila, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPanePlačilo.setLayer(jRadioButtonGotovina, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPanePlačilo.setLayer(jRadioButtonKartica, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPanePlačilo.setLayer(jButtonIzvediPlacilo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPanePlačilo.setLayer(jLabelStKartice, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPanePlačilo.setLayer(jLabelCCV, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPanePlačilo.setLayer(jTextFieldCCV, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPanePlačilo.setLayer(jLayeredPaneZnesek, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPanePlačilo.setLayer(jButtonPonastavi, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPanePlačilo.setLayer(jButtonShrani, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPanePlačilo.setLayer(jPasswordFieldStKartice, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPanePlačiloLayout = new javax.swing.GroupLayout(jLayeredPanePlačilo);
        jLayeredPanePlačilo.setLayout(jLayeredPanePlačiloLayout);
        jLayeredPanePlačiloLayout.setHorizontalGroup(
            jLayeredPanePlačiloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPanePlačiloLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPanePlačiloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLayeredPaneZnesek)
                    .addGroup(jLayeredPanePlačiloLayout.createSequentialGroup()
                        .addGroup(jLayeredPanePlačiloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPanePlačiloLayout.createSequentialGroup()
                                .addComponent(jLabelMoznostPlacila, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(28, 28, 28))
                            .addGroup(jLayeredPanePlačiloLayout.createSequentialGroup()
                                .addComponent(jLabelStKartice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jLayeredPanePlačiloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButtonGotovina, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jLayeredPanePlačiloLayout.createSequentialGroup()
                                .addComponent(jPasswordFieldStKartice)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jLayeredPanePlačiloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPanePlačiloLayout.createSequentialGroup()
                                .addComponent(jRadioButtonKartica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(88, 88, 88))
                            .addGroup(jLayeredPanePlačiloLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabelCCV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldCCV, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70)))))
                .addGap(25, 25, 25))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPanePlačiloLayout.createSequentialGroup()
                .addGap(199, 199, 199)
                .addGroup(jLayeredPanePlačiloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonShrani, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonPonastavi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonIzvediPlacilo, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                .addGap(139, 139, 139))
        );
        jLayeredPanePlačiloLayout.setVerticalGroup(
            jLayeredPanePlačiloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPanePlačiloLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPanePlačiloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelMoznostPlacila)
                    .addComponent(jRadioButtonGotovina)
                    .addComponent(jRadioButtonKartica))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jLayeredPanePlačiloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelStKartice)
                    .addComponent(jLabelCCV)
                    .addComponent(jTextFieldCCV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPasswordFieldStKartice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jLayeredPaneZnesek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonIzvediPlacilo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonShrani)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonPonastavi)
                .addGap(40, 40, 40))
        );

        jLabelStatus.setText("Status:");

        javax.swing.GroupLayout jPanelMainLayout = new javax.swing.GroupLayout(jPanelMain);
        jPanelMain.setLayout(jPanelMainLayout);
        jPanelMainLayout.setHorizontalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLayeredPaneAvtomobil)
                    .addComponent(jLayeredPaneOseba))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLayeredPanePlačilo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addComponent(jLabelStatus)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelMainLayout.setVerticalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addComponent(jLayeredPaneAvtomobil)
                        .addGap(5, 5, 5)
                        .addComponent(jLayeredPaneOseba))
                    .addComponent(jLayeredPanePlačilo))
                .addGap(13, 13, 13)
                .addComponent(jLabelStatus))
        );

        jMenuDatoteka.setMnemonic('D');
        jMenuDatoteka.setText("Datoteka");

        jMenuItemOdpri.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemOdpri.setMnemonic('O');
        jMenuItemOdpri.setText("Odpri");
        jMenuItemOdpri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                odpriVnos(evt);
            }
        });
        jMenuDatoteka.add(jMenuItemOdpri);

        jMenuItemShrani.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemShrani.setMnemonic('S');
        jMenuItemShrani.setText("Shrani");
        jMenuItemShrani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shraniVnos(evt);
            }
        });
        jMenuDatoteka.add(jMenuItemShrani);

        jMenuItemIzhod.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemIzhod.setMnemonic('I');
        jMenuItemIzhod.setText("Izhod");
        jMenuItemIzhod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitApplication(evt);
            }
        });
        jMenuDatoteka.add(jMenuItemIzhod);

        jMenuBarMain.add(jMenuDatoteka);

        jMenuUredi.setMnemonic('U');
        jMenuUredi.setText("Uredi");

        jMenuItem4.setMnemonic('P');
        jMenuItem4.setText("Ponastavi");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetValues(evt);
            }
        });
        jMenuUredi.add(jMenuItem4);

        jMenuBarMain.add(jMenuUredi);

        jMenuPomoc.setMnemonic('P');
        jMenuPomoc.setText("Pomoč");

        jMenuItemAvtor.setMnemonic('A');
        jMenuItemAvtor.setText("Avtor");
        jMenuItemAvtor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showAuthor(evt);
            }
        });
        jMenuPomoc.add(jMenuItemAvtor);

        jMenuBarMain.add(jMenuPomoc);

        setJMenuBar(jMenuBarMain);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void smallCarSizeSelected(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smallCarSizeSelected
        fillCars();
        
        updateCena(this.majhnaCena);           
    }//GEN-LAST:event_smallCarSizeSelected

    private void mediumCarSizeSelected(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mediumCarSizeSelected
        fillCars();

        updateCena(this.srednjaCena);        
    }//GEN-LAST:event_mediumCarSizeSelected

    private void largeCarSizeSelected(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_largeCarSizeSelected
       fillCars();

       updateCena(this.visokaCena);
    }//GEN-LAST:event_largeCarSizeSelected

    private void dodatnoZavarovanjeSelected(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dodatnoZavarovanjeSelected
                     
        if (!this.dodatnoZavarovanje) {
            
            this.dodatnoZavarovanje = true;
            
            String textDnevnaCena = jLabelDnevnaNajemnina.getText();
            int dnevnaCena = Integer.parseInt(textDnevnaCena);       
            dnevnaCena += 2;   
            jLabelDnevnaNajemnina.setText(Integer.toString(dnevnaCena));

            String textSkupnaCena = jLabelSkupnaNajemnina.getText();
            int skupnaCena = Integer.parseInt(textSkupnaCena);
            int vsiDnevi = calculateNumberOfDays();
            skupnaCena += 2 * vsiDnevi;
            jLabelSkupnaNajemnina.setText(Integer.toString(skupnaCena));
            
        }
        
    }//GEN-LAST:event_dodatnoZavarovanjeSelected

    private void dodatnoZavarovanjeDiselected(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dodatnoZavarovanjeDiselected
             
        if (this.dodatnoZavarovanje) {
            
            this.dodatnoZavarovanje = false;
            
            String textDnevnaCena = jLabelDnevnaNajemnina.getText();
            int dnevnaCena = Integer.parseInt(textDnevnaCena);       
            dnevnaCena -= 2;   
            jLabelDnevnaNajemnina.setText(Integer.toString(dnevnaCena));

            String textSkupnaCena = jLabelSkupnaNajemnina.getText();
            int skupnaCena = Integer.parseInt(textSkupnaCena);
            int vsiDnevi = calculateNumberOfDays();
            skupnaCena -= 2 * vsiDnevi;
            jLabelSkupnaNajemnina.setText(Integer.toString(skupnaCena));
        }
        
    }//GEN-LAST:event_dodatnoZavarovanjeDiselected

    private void dateChanged(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateChanged
        
        if (jRadioButtonVelikostMajhen.isSelected()) {
            updateCena(this.majhnaCena);
        } else if (jRadioButtonVelikostSrednji.isSelected()) {
            updateCena(this.srednjaCena);
        } else if (jRadioButtonVelikostVelik.isSelected()) {
            updateCena(this.visokaCena);
        }   
    }//GEN-LAST:event_dateChanged

    private void exitApplication(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitApplication
        
        System.exit(0);       
    }//GEN-LAST:event_exitApplication

    private void resetValues(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetValues
        
        int dialogResult = JOptionPane.showConfirmDialog(this, "Ali ste prepričani, da želite izbrisati vnos?", "Izbris vnosa", JOptionPane.YES_NO_OPTION);
        if(dialogResult == JOptionPane.YES_OPTION) {
            jTextFieldCCV.setText("");
            jTextFieldEposta.setText("");
            jTextFieldIme.setText("");
            jTextFieldKraj.setText("");
            jTextFieldPostnaSt.setText("");
            jTextFieldPriimek.setText("");
            jPasswordFieldStKartice.setText("");
            jTextFieldTelefon.setText("");
            jTextFieldUlica.setText("");

            jComboBoxIzposojaDan.setSelectedIndex(0);
            jComboBoxIzposojaMesec.setSelectedIndex(0);
            jComboBoxIzposojaUra.setSelectedIndex(0);
            jComboBoxOddajaDan.setSelectedIndex(0);
            jComboBoxOddajaMesec.setSelectedIndex(0);
            jComboBoxOddajaUra.setSelectedIndex(0);

            jSpinnerStarost.setValue(21);
            jSpinnerIzkusnje.setValue(0);

            jLabelStatus.setText("Status: Vnos pobrisan");
        }
            

    }//GEN-LAST:event_resetValues

    private void izvediPlacilo(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_izvediPlacilo
 
        boolean preveriVnos = true;
        
        if (jTextFieldIme.getText().isEmpty() || jTextFieldPriimek.getText().isEmpty() || jTextFieldKraj.getText().isEmpty() 
                || jTextFieldPostnaSt.getText().isEmpty() || jTextFieldTelefon.getText().isEmpty() || jTextFieldUlica.getText().isEmpty()
                || jTextFieldEposta.getText().isEmpty()) {
            
            preveriVnos = false;            
        }
        
        if(preveriVnos) {
            if (jRadioButtonKartica.isSelected()) {                  
                if (jPasswordFieldStKartice.getPassword().length == 16 && jTextFieldCCV.getText().length() == 3 ) {
                    JOptionPane.showMessageDialog(this, "Plačilo uspešno.", "Plačilo", JOptionPane.INFORMATION_MESSAGE);
                    jLabelStatus.setText("Status: Plačilo uspešno.");
                } else if (jPasswordFieldStKartice.getPassword().length == 16 && jTextFieldCCV.getText().length() != 3) {
                    JOptionPane.showMessageDialog(this, "Napačen vnos CCV.", "Plačilo", JOptionPane.WARNING_MESSAGE);
                    jLabelStatus.setText("Status: Napaka pri plačilu.");
                } else if (jPasswordFieldStKartice.getPassword().length != 16 && jTextFieldCCV.getText().length() == 3) {
                    JOptionPane.showMessageDialog(this, "Napačen vnos številke kreditne kartice.", "Plačilo", JOptionPane.WARNING_MESSAGE);
                    jLabelStatus.setText("Status: Napaka pri plačilu.");
                } else {
                    JOptionPane.showMessageDialog(this, "Napačen vnos številke kreditne kartice in CCV.", "Plačilo", JOptionPane.WARNING_MESSAGE);
                    jLabelStatus.setText("Status: Napaka pri plačilu.");
                }            
            } else {            
                JOptionPane.showMessageDialog(this, "Plačilo uspešno.", "Plačilo", JOptionPane.INFORMATION_MESSAGE);
                jLabelStatus.setText("Status: Plačilo uspešno.");           
            }
        } else {
            JOptionPane.showMessageDialog(this, "Napaka, mankajo podatki o osebi.", "Plačilo", JOptionPane.WARNING_MESSAGE);
            jLabelStatus.setText("Status: Napaka pri vnosu podatkov o osebi"); 
        }
        

        
    }//GEN-LAST:event_izvediPlacilo

    private void showAuthor(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showAuthor
        
        JOptionPane.showMessageDialog(this, "Tilen Berlak\n63160064\nMaj 2020", "O Avtorju", JOptionPane.INFORMATION_MESSAGE);
        
    }//GEN-LAST:event_showAuthor

    private void shraniVnos(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shraniVnos
        
        if(jFileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            JOptionPane.showMessageDialog(this, "Vnos shranjen.", "Shrani vnos", JOptionPane.INFORMATION_MESSAGE);
            jLabelStatus.setText("Status: Vnos shranjen");
        }
        
    }//GEN-LAST:event_shraniVnos

    private void odpriVnos(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_odpriVnos
        
        if(jFileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {       
            jLabelStatus.setText("Status: Vnos odprt");
        }
        
    }//GEN-LAST:event_odpriVnos

    private void preveriPostnaSt(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_preveriPostnaSt
        
        String text = jTextFieldPostnaSt.getText();
        
        if(!text.matches("[0-9]+") && text.length() != 4) {
             JOptionPane.showMessageDialog(this, "Poštna številka " + text + " je neveljavna.", "Opozorilo", JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_preveriPostnaSt

    private void karticaSelected(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_karticaSelected
        
        jLabelStKartice.setEnabled(true);
        jLabelCCV.setEnabled(true);
        jPasswordFieldStKartice.setEnabled(true);
        jTextFieldCCV.setEnabled(true);
        
    }//GEN-LAST:event_karticaSelected

    private void gotovinaSelected(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gotovinaSelected
        
        jLabelStKartice.setEnabled(false);
        jLabelCCV.setEnabled(false);
        jPasswordFieldStKartice.setEnabled(false);
        jTextFieldCCV.setEnabled(false);
        
    }//GEN-LAST:event_gotovinaSelected

    private void jRadioButtonMotorDizelskiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMotorDizelskiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonMotorDizelskiActionPerformed

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
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupDodatnoZavarovanje;
    private javax.swing.ButtonGroup buttonGroupIzbiraMenjalnika;
    private javax.swing.ButtonGroup buttonGroupMoznostPlacila;
    private javax.swing.ButtonGroup buttonGroupVelikostAvtomobila;
    private javax.swing.ButtonGroup buttonGroupVrstaMotorja;
    private javax.swing.JButton jButtonIzvediPlacilo;
    private javax.swing.JButton jButtonPonastavi;
    private javax.swing.JButton jButtonShrani;
    private javax.swing.JComboBox<String> jComboBoxIzbiraAvtomobila;
    private javax.swing.JComboBox<String> jComboBoxIzposojaDan;
    private javax.swing.JComboBox<String> jComboBoxIzposojaMesec;
    private javax.swing.JComboBox<String> jComboBoxIzposojaUra;
    private javax.swing.JComboBox<String> jComboBoxMestoOddaje;
    private javax.swing.JComboBox<String> jComboBoxOddajaDan;
    private javax.swing.JComboBox<String> jComboBoxOddajaMesec;
    private javax.swing.JComboBox<String> jComboBoxOddajaUra;
    private javax.swing.JComboBox<String> jComboBoxPrevzemnoMesto;
    private javax.swing.JFileChooser jFileChooser;
    private javax.swing.JLabel jLabelCCV;
    private javax.swing.JLabel jLabelDatumIzposoje;
    private javax.swing.JLabel jLabelDatumOddaje;
    private javax.swing.JLabel jLabelDnesvniZnesek;
    private javax.swing.JLabel jLabelDnevnaNajemnina;
    private javax.swing.JLabel jLabelDodatnoZav;
    private javax.swing.JLabel jLabelEposta;
    private javax.swing.JLabel jLabelImeOsebe;
    private javax.swing.JLabel jLabelIzbiraAvtomobila;
    private javax.swing.JLabel jLabelIzbiraMenjalnika;
    private javax.swing.JLabel jLabelIzkusnje;
    private javax.swing.JLabel jLabelKrajOsebe;
    private javax.swing.JLabel jLabelMestoOddaje;
    private javax.swing.JLabel jLabelMoznostPlacila;
    private javax.swing.JLabel jLabelPostnaSt;
    private javax.swing.JLabel jLabelPrevzemnoMesto;
    private javax.swing.JLabel jLabelPriimekOsebe;
    private javax.swing.JLabel jLabelSkupnaNajemnina;
    private javax.swing.JLabel jLabelSkupniZnesek;
    private javax.swing.JLabel jLabelStKartice;
    private javax.swing.JLabel jLabelStarostOsebe;
    private javax.swing.JLabel jLabelStatus;
    private javax.swing.JLabel jLabelTelefonOsebe;
    private javax.swing.JLabel jLabelUlicaOsebe;
    private javax.swing.JLabel jLabelVelikostAvtomobila;
    private javax.swing.JLabel jLabelVrstaMotorja;
    private javax.swing.JLayeredPane jLayeredPaneAvtomobil;
    private javax.swing.JLayeredPane jLayeredPaneOseba;
    private javax.swing.JLayeredPane jLayeredPanePlačilo;
    private javax.swing.JLayeredPane jLayeredPaneZnesek;
    private javax.swing.JMenuBar jMenuBarMain;
    private javax.swing.JMenu jMenuDatoteka;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItemAvtor;
    private javax.swing.JMenuItem jMenuItemIzhod;
    private javax.swing.JMenuItem jMenuItemOdpri;
    private javax.swing.JMenuItem jMenuItemShrani;
    private javax.swing.JMenu jMenuPomoc;
    private javax.swing.JMenu jMenuUredi;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JPasswordField jPasswordFieldStKartice;
    private javax.swing.JRadioButton jRadioButtonDodatnoDa;
    private javax.swing.JRadioButton jRadioButtonDodatnoNe;
    private javax.swing.JRadioButton jRadioButtonGotovina;
    private javax.swing.JRadioButton jRadioButtonKartica;
    private javax.swing.JRadioButton jRadioButtonMenjalnikRočni;
    private javax.swing.JRadioButton jRadioButtonMenjalnikSamodejni;
    private javax.swing.JRadioButton jRadioButtonMotorBencinski;
    private javax.swing.JRadioButton jRadioButtonMotorDizelski;
    private javax.swing.JRadioButton jRadioButtonVelikostMajhen;
    private javax.swing.JRadioButton jRadioButtonVelikostSrednji;
    private javax.swing.JRadioButton jRadioButtonVelikostVelik;
    private javax.swing.JSpinner jSpinnerIzkusnje;
    private javax.swing.JSpinner jSpinnerStarost;
    private javax.swing.JTextField jTextFieldCCV;
    private javax.swing.JTextField jTextFieldEposta;
    private javax.swing.JTextField jTextFieldIme;
    private javax.swing.JTextField jTextFieldKraj;
    private javax.swing.JTextField jTextFieldPostnaSt;
    private javax.swing.JTextField jTextFieldPriimek;
    private javax.swing.JTextField jTextFieldTelefon;
    private javax.swing.JTextField jTextFieldUlica;
    // End of variables declaration//GEN-END:variables
}
