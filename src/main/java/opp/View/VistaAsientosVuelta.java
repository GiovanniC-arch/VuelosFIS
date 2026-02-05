
package opp.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import oop.Repository.OcupacionAsientosRepository;
import opp.Model.Reserva;
import opp.Model.Vuelo;

public class VistaAsientosVuelta extends javax.swing.JFrame {
    
    private DefaultTableModel modeloTabla;
    private int contadorPasajeros = 1;
    private int limitePasajeros;
    private Vuelo vuelo;
    private OcupacionAsientosRepository ocupacionRepo;
    private Reserva reserva;

    public VistaAsientosVuelta(Reserva reserva, Vuelo vuelo, OcupacionAsientosRepository repo) {
        initComponents();
        this.reserva = reserva;
        this.limitePasajeros = reserva.getPasajeros();
        this.vuelo = vuelo;
        this.ocupacionRepo = repo;
        configurarTabla();
        configurarEventosBotones();
        bloquearAsientosOcupados();
    }

    private void configurarTabla() {
        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("Pasajero");
        modeloTabla.addColumn("Asiento");
        modeloTabla.addColumn("Precio");
        tblAsientosVuelta.setModel(modeloTabla);
    }

    private void seleccionarAsiento(String codigoAsiento, JButton boton) {
        if (contadorPasajeros > limitePasajeros) {
            JOptionPane.showMessageDialog(this,
                    "Ya se seleccionaron todos los asientos permitidos (" + limitePasajeros + ")",
                    "Límite alcanzado", JOptionPane.WARNING_MESSAGE);
            return;
        }

        double precio = 12.0;

        modeloTabla.addRow(new Object[]{
            "Pasajero " + contadorPasajeros,
            codigoAsiento,
            precio
        });

        contadorPasajeros++;
        boton.setEnabled(false);

        // Guardar ocupación como VUELTA
        ocupacionRepo.ocuparAsiento(vuelo, codigoAsiento, true);

        // Guardar asiento en la reserva
        reserva.addAsientoVuelta(codigoAsiento);

        if (contadorPasajeros > limitePasajeros) {
            deshabilitarTodosLosBotones();
        }
    }

    private void bloquearAsientosOcupados() {
        String[] codigos = {"A1","A2","A3","A4","A5",
                            "B1","B2","B3","B4","B5",
                            "C1","C2","C3","C4","C5",
                            "D1","D2","D3","D4","D5"};
        for (String codigo : codigos) {
            if (ocupacionRepo.estaOcupado(vuelo, codigo, true)) {
                deshabilitarBoton(codigo);
            }
        }
    }




    private void configurarEventosBotones() {
        // Fila A
        btnVA1.addActionListener(e -> seleccionarAsiento("A1", btnVA1));
        btnVA2.addActionListener(e -> seleccionarAsiento("A2", btnVA2));
        btnVA3.addActionListener(e -> seleccionarAsiento("A3", btnVA3));
        btnVA4.addActionListener(e -> seleccionarAsiento("A4", btnVA4));
        btnVA5.addActionListener(e -> seleccionarAsiento("A5", btnVA5));

        // Fila B
        btnVB1.addActionListener(e -> seleccionarAsiento("B1", btnVB1));
        btnVB2.addActionListener(e -> seleccionarAsiento("B2", btnVB2));
        btnVB3.addActionListener(e -> seleccionarAsiento("B3", btnVB3));
        btnVB4.addActionListener(e -> seleccionarAsiento("B4", btnVB4));
        btnVB5.addActionListener(e -> seleccionarAsiento("B5", btnVB5));

        // Fila C
        btnVC1.addActionListener(e -> seleccionarAsiento("C1", btnVC1));
        btnVC2.addActionListener(e -> seleccionarAsiento("C2", btnVC2));
        btnVC3.addActionListener(e -> seleccionarAsiento("C3", btnVC3));
        btnVC4.addActionListener(e -> seleccionarAsiento("C4", btnVC4));
        btnVC5.addActionListener(e -> seleccionarAsiento("C5", btnVC5));

        // Fila D
        btnVD1.addActionListener(e -> seleccionarAsiento("D1", btnVD1));
        btnVD2.addActionListener(e -> seleccionarAsiento("D2", btnVD2));
        btnVD3.addActionListener(e -> seleccionarAsiento("D3", btnVD3));
        btnVD4.addActionListener(e -> seleccionarAsiento("D4", btnVD4));
        btnVD5.addActionListener(e -> seleccionarAsiento("D5", btnVD5));
    }

    private void deshabilitarBoton(String codigoAsiento) {
        switch (codigoAsiento) {
            case "A1": btnVA1.setEnabled(false); break;
            case "A2": btnVA2.setEnabled(false); break;
            case "A3": btnVA3.setEnabled(false); break;
            case "A4": btnVA4.setEnabled(false); break;
            case "A5": btnVA5.setEnabled(false); break;
            case "B1": btnVB1.setEnabled(false); break;
            case "B2": btnVB2.setEnabled(false); break;
            case "B3": btnVB3.setEnabled(false); break;
            case "B4": btnVB4.setEnabled(false); break;
            case "B5": btnVB5.setEnabled(false); break;
            case "C1": btnVC1.setEnabled(false); break;
            case "C2": btnVC2.setEnabled(false); break;
            case "C3": btnVC3.setEnabled(false); break;
            case "C4": btnVC4.setEnabled(false); break;
            case "C5": btnVC5.setEnabled(false); break;
            case "D1": btnVD1.setEnabled(false); break;
            case "D2": btnVD2.setEnabled(false); break;
            case "D3": btnVD3.setEnabled(false); break;
            case "D4": btnVD4.setEnabled(false); break;
            case "D5": btnVD5.setEnabled(false); break;
        }
    }

    private void deshabilitarTodosLosBotones() {
        btnVA1.setEnabled(false); btnVA2.setEnabled(false); btnVA3.setEnabled(false);
        btnVA4.setEnabled(false); btnVA5.setEnabled(false);
        btnVB1.setEnabled(false); btnVB2.setEnabled(false); btnVB3.setEnabled(false);
        btnVB4.setEnabled(false); btnVB5.setEnabled(false);
        btnVC1.setEnabled(false); btnVC2.setEnabled(false); btnVC3.setEnabled(false);
        btnVC4.setEnabled(false); btnVC5.setEnabled(false);
        btnVD1.setEnabled(false); btnVD2.setEnabled(false); btnVD3.setEnabled(false);
        btnVD4.setEnabled(false); btnVD5.setEnabled(false);
    }






    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnVA1 = new javax.swing.JButton();
        btnVD1 = new javax.swing.JButton();
        btnVB1 = new javax.swing.JButton();
        btnVC1 = new javax.swing.JButton();
        btnVA2 = new javax.swing.JButton();
        btnVB2 = new javax.swing.JButton();
        btnVC2 = new javax.swing.JButton();
        btnVD2 = new javax.swing.JButton();
        btnVA4 = new javax.swing.JButton();
        btnVB4 = new javax.swing.JButton();
        btnVD4 = new javax.swing.JButton();
        btnVC4 = new javax.swing.JButton();
        btnVA3 = new javax.swing.JButton();
        btnVB3 = new javax.swing.JButton();
        btnVC3 = new javax.swing.JButton();
        btnVD3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnSiguiente2 = new javax.swing.JButton();
        btnVA5 = new javax.swing.JButton();
        btnVB5 = new javax.swing.JButton();
        btnVC5 = new javax.swing.JButton();
        btnVD5 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAsientosVuelta = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(182, 221, 252));

        jPanel2.setBackground(new java.awt.Color(0, 153, 204));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logoavion.png"))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 3, 18)); // NOI18N
        jLabel7.setText("VuelosFIS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(151, 151, 151))
        );

        btnVA1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnVA1.setText("A1");
        btnVA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVA1ActionPerformed(evt);
            }
        });

        btnVD1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnVD1.setText("D1");
        btnVD1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVD1ActionPerformed(evt);
            }
        });

        btnVB1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnVB1.setText("B1");
        btnVB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVB1ActionPerformed(evt);
            }
        });

        btnVC1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnVC1.setText("C1");
        btnVC1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVC1ActionPerformed(evt);
            }
        });

        btnVA2.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnVA2.setText("A2");

        btnVB2.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnVB2.setText("B2");

        btnVC2.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnVC2.setText("C2");

        btnVD2.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnVD2.setText("D2");

        btnVA4.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnVA4.setText("A4");

        btnVB4.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnVB4.setText("B4");

        btnVD4.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnVD4.setText("D4");

        btnVC4.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnVC4.setText("C4");

        btnVA3.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnVA3.setText("A3");

        btnVB3.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnVB3.setText("B3");

        btnVC3.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnVC3.setText("C3");

        btnVD3.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnVD3.setText("D3");

        jLabel2.setText("A");

        jLabel3.setText("B");

        jLabel4.setText("C");

        jLabel5.setText("D");

        jLabel6.setText("1");

        jLabel8.setText("2");

        jLabel9.setText("3");

        jLabel10.setText("4");

        jLabel11.setFont(new java.awt.Font("Segoe UI Black", 3, 18)); // NOI18N
        jLabel11.setText("Seleccione Asientos de Vuelta");

        btnSiguiente2.setBackground(new java.awt.Color(51, 153, 255));
        btnSiguiente2.setFont(new java.awt.Font("Segoe UI Semibold", 3, 18)); // NOI18N
        btnSiguiente2.setText("Siguiente");
        btnSiguiente2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguiente2ActionPerformed(evt);
            }
        });

        btnVA5.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnVA5.setText("A5");
        btnVA5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVA5ActionPerformed(evt);
            }
        });

        btnVB5.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnVB5.setText("B5");
        btnVB5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVB5ActionPerformed(evt);
            }
        });

        btnVC5.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnVC5.setText("C5");
        btnVC5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVC5ActionPerformed(evt);
            }
        });

        btnVD5.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnVD5.setText("D5");

        jLabel12.setText("5");

        tblAsientosVuelta.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblAsientosVuelta);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSiguiente2)
                .addGap(188, 188, 188))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel6)
                        .addComponent(jLabel8)
                        .addComponent(jLabel9)
                        .addComponent(jLabel10))
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnVA4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVB4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(btnVC4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVD4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnVA3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVB3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(btnVC3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVD3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2)
                        .addGap(39, 39, 39)
                        .addComponent(jLabel3)
                        .addGap(81, 81, 81)
                        .addComponent(jLabel4)
                        .addGap(43, 43, 43)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnVA5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVB5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(btnVC5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVD5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnVA1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(btnVA2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnVB2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(btnVC2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnVD2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnVB1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(btnVC1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnVD1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11)
                        .addGap(73, 73, 73)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnVA1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVB1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVD1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVC1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnVA2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVB2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVD2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVC2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnVA3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVB3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVD3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVC3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnVA4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVB4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVD4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVC4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnVA5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVB5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVD5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVC5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(btnSiguiente2)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 640));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVA1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVA1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVA1ActionPerformed

    private void btnVC1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVC1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVC1ActionPerformed

    private void btnVB1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVB1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVB1ActionPerformed

    private void btnSiguiente2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguiente2ActionPerformed
        if (contadorPasajeros <= limitePasajeros - 1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar todos los asientos antes de continuar", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        VistaInfoPasajeros vistaInfo = new VistaInfoPasajeros(reserva);
        vistaInfo.setVisible(true);
        this.dispose();




    }//GEN-LAST:event_btnSiguiente2ActionPerformed

    private void btnVA5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVA5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVA5ActionPerformed

    private void btnVB5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVB5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVB5ActionPerformed

    private void btnVC5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVC5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVC5ActionPerformed

    private void btnVD1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVD1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVD1ActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSiguiente2;
    private javax.swing.JButton btnVA1;
    private javax.swing.JButton btnVA2;
    private javax.swing.JButton btnVA3;
    private javax.swing.JButton btnVA4;
    private javax.swing.JButton btnVA5;
    private javax.swing.JButton btnVB1;
    private javax.swing.JButton btnVB2;
    private javax.swing.JButton btnVB3;
    private javax.swing.JButton btnVB4;
    private javax.swing.JButton btnVB5;
    private javax.swing.JButton btnVC1;
    private javax.swing.JButton btnVC2;
    private javax.swing.JButton btnVC3;
    private javax.swing.JButton btnVC4;
    private javax.swing.JButton btnVC5;
    private javax.swing.JButton btnVD1;
    private javax.swing.JButton btnVD2;
    private javax.swing.JButton btnVD3;
    private javax.swing.JButton btnVD4;
    private javax.swing.JButton btnVD5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblAsientosVuelta;
    // End of variables declaration//GEN-END:variables
}
