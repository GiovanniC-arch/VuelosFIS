
package opp.View;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import oop.Repository.OcupacionAsientosRepository;
import javax.swing.table.DefaultTableModel;
import opp.Controller.ReservaController;
import opp.Model.Reserva;
import opp.Model.Vuelo;

public class VistaAsientos extends javax.swing.JFrame {
    
    private DefaultTableModel modeloTabla;
    private int contadorPasajeros = 1;
    private int limitePasajeros;
    private Vuelo vuelo;
    private OcupacionAsientosRepository ocupacionRepo;
    private Reserva reserva;
    private ReservaController reservaController;


    public VistaAsientos(Reserva reserva, Vuelo vuelo, OcupacionAsientosRepository repo, ReservaController reservaController) {
    initComponents();
    this.reserva = reserva;
    this.limitePasajeros = reserva.getPasajeros();
    this.vuelo = vuelo;
    this.ocupacionRepo = repo;
    this.reservaController = reservaController; // guardamos el controller
    configurarTabla();
    configurarEventosBotones();
    bloquearAsientosOcupados();
}


    private void configurarTabla() {
        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("Pasajero");
        modeloTabla.addColumn("Asiento");
        modeloTabla.addColumn("Precio");
        tblAsientosIda.setModel(modeloTabla);
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

        // Guardar ocupación como IDA
        ocupacionRepo.ocuparAsiento(vuelo, codigoAsiento, false);

        // Guardar asiento en la reserva
        reserva.addAsientoIda(codigoAsiento);

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
            if (ocupacionRepo.estaOcupado(vuelo, codigo, false)) {
                deshabilitarBoton(codigo);
            }
        }
    }


    
    private void configurarEventosBotones() {
    // Fila A
    btnA1.addActionListener(e -> seleccionarAsiento("A1", btnA1));
    btnA2.addActionListener(e -> seleccionarAsiento("A2", btnA2));
    btnA3.addActionListener(e -> seleccionarAsiento("A3", btnA3));
    btnA4.addActionListener(e -> seleccionarAsiento("A4", btnA4));
    btnA5.addActionListener(e -> seleccionarAsiento("A5", btnA5));

    // Fila B
    btnB1.addActionListener(e -> seleccionarAsiento("B1", btnB1));
    btnB2.addActionListener(e -> seleccionarAsiento("B2", btnB2));
    btnB3.addActionListener(e -> seleccionarAsiento("B3", btnB3));
    btnB4.addActionListener(e -> seleccionarAsiento("B4", btnB4));
    btnB5.addActionListener(e -> seleccionarAsiento("B5", btnB5));

    // Fila C
    btnC1.addActionListener(e -> seleccionarAsiento("C1", btnC1));
    btnC2.addActionListener(e -> seleccionarAsiento("C2", btnC2));
    btnC3.addActionListener(e -> seleccionarAsiento("C3", btnC3));
    btnC4.addActionListener(e -> seleccionarAsiento("C4", btnC4));
    btnC5.addActionListener(e -> seleccionarAsiento("C5", btnC5));

    // Fila D
    btnD1.addActionListener(e -> seleccionarAsiento("D1", btnD1));
    btnD2.addActionListener(e -> seleccionarAsiento("D2", btnD2));
    btnD3.addActionListener(e -> seleccionarAsiento("D3", btnD3));
    btnD4.addActionListener(e -> seleccionarAsiento("D4", btnD4));
    btnD5.addActionListener(e -> seleccionarAsiento("D5", btnD5));
}

    
    private void deshabilitarBoton(String codigoAsiento) {
        switch (codigoAsiento) {
            case "A1": btnA1.setEnabled(false); break;
            case "A2": btnA2.setEnabled(false); break;
            case "A3": btnA3.setEnabled(false); break;
            case "A4": btnA4.setEnabled(false); break;
            case "A5": btnA5.setEnabled(false); break;
            case "B1": btnB1.setEnabled(false); break;
            case "B2": btnB2.setEnabled(false); break;
            case "B3": btnB3.setEnabled(false); break;
            case "B4": btnB4.setEnabled(false); break;
            case "B5": btnB5.setEnabled(false); break;
            case "C1": btnC1.setEnabled(false); break;
            case "C2": btnC2.setEnabled(false); break;
            case "C3": btnC3.setEnabled(false); break;
            case "C4": btnC4.setEnabled(false); break;
            case "C5": btnC5.setEnabled(false); break;
            case "D1": btnD1.setEnabled(false); break;
            case "D2": btnD2.setEnabled(false); break;
            case "D3": btnD3.setEnabled(false); break;
            case "D4": btnD4.setEnabled(false); break;
            case "D5": btnD5.setEnabled(false); break;
        }
    }





    
    private void deshabilitarTodosLosBotones() {
        btnA1.setEnabled(false); btnA2.setEnabled(false); btnA3.setEnabled(false);
        btnA4.setEnabled(false); btnA5.setEnabled(false);
        btnB1.setEnabled(false); btnB2.setEnabled(false); btnB3.setEnabled(false);
        btnB4.setEnabled(false); btnB5.setEnabled(false);
        btnC1.setEnabled(false); btnC2.setEnabled(false); btnC3.setEnabled(false);
        btnC4.setEnabled(false); btnC5.setEnabled(false);
        btnD1.setEnabled(false); btnD2.setEnabled(false); btnD3.setEnabled(false);
        btnD4.setEnabled(false); btnD5.setEnabled(false);
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
        btnA1 = new javax.swing.JButton();
        btnD1 = new javax.swing.JButton();
        btnB1 = new javax.swing.JButton();
        btnC1 = new javax.swing.JButton();
        btnA2 = new javax.swing.JButton();
        btnB2 = new javax.swing.JButton();
        btnC2 = new javax.swing.JButton();
        btnD2 = new javax.swing.JButton();
        btnA4 = new javax.swing.JButton();
        btnB4 = new javax.swing.JButton();
        btnD4 = new javax.swing.JButton();
        btnC4 = new javax.swing.JButton();
        btnA3 = new javax.swing.JButton();
        btnB3 = new javax.swing.JButton();
        btnC3 = new javax.swing.JButton();
        btnD3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnSiguiente = new javax.swing.JButton();
        btnA5 = new javax.swing.JButton();
        btnB5 = new javax.swing.JButton();
        btnC5 = new javax.swing.JButton();
        btnD5 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAsientosIda = new javax.swing.JTable();

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
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(783, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        btnA1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnA1.setText("A1");
        btnA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnA1ActionPerformed(evt);
            }
        });

        btnD1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnD1.setText("D1");

        btnB1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnB1.setText("B1");
        btnB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnB1ActionPerformed(evt);
            }
        });

        btnC1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnC1.setText("C1");
        btnC1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnC1ActionPerformed(evt);
            }
        });

        btnA2.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnA2.setText("A2");

        btnB2.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnB2.setText("B2");

        btnC2.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnC2.setText("C2");

        btnD2.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnD2.setText("D2");

        btnA4.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnA4.setText("A4");

        btnB4.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnB4.setText("B4");

        btnD4.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnD4.setText("D4");

        btnC4.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnC4.setText("C4");

        btnA3.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnA3.setText("A3");

        btnB3.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnB3.setText("B3");

        btnC3.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnC3.setText("C3");

        btnD3.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnD3.setText("D4");

        jLabel2.setText("A");

        jLabel3.setText("B");

        jLabel4.setText("C");

        jLabel5.setText("D");

        jLabel6.setText("1");

        jLabel8.setText("2");

        jLabel9.setText("3");

        jLabel10.setText("4");

        btnSiguiente.setBackground(new java.awt.Color(51, 153, 255));
        btnSiguiente.setFont(new java.awt.Font("Segoe UI Semibold", 3, 18)); // NOI18N
        btnSiguiente.setText("Siguiente");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        btnA5.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnA5.setText("A5");

        btnB5.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnB5.setText("B5");

        btnC5.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnC5.setText("C5");

        btnD5.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnD5.setText("D5");

        jLabel12.setText("5");

        jLabel11.setFont(new java.awt.Font("Segoe UI Black", 3, 24)); // NOI18N
        jLabel11.setText("Seleccione Asientos de Ida");

        tblAsientosIda.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblAsientosIda);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel11)
                .addGap(184, 184, 184)
                .addComponent(btnSiguiente)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel6)
                        .addComponent(jLabel8)
                        .addComponent(jLabel9)
                        .addComponent(jLabel10))
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnA5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnB5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(btnC5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnD5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnA4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnB4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(btnC4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnD4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnA3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnB3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(btnC3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnD3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnA2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnB2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(btnC2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnD2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnA1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnB1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(btnC1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnD1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2)
                        .addGap(39, 39, 39)
                        .addComponent(jLabel3)
                        .addGap(81, 81, 81)
                        .addComponent(jLabel4)
                        .addGap(43, 43, 43)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSiguiente)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(34, 34, 34)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnA1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnB1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnD1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnC1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnA2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnB2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnD2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnC2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnA3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnB3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnD3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnC3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnA4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnB4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnD4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnC4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnA5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnB5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnD5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnC5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnA1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnA1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnA1ActionPerformed

    private void btnC1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnC1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnC1ActionPerformed

    private void btnB1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnB1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnB1ActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        // TODO add your handling code here:
        if (contadorPasajeros <= limitePasajeros - 1) {
            JOptionPane.showMessageDialog(this, 
                "Debe seleccionar todos los asientos antes de continuar", 
                "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (reserva.isEsIdaVuelta()) {
    // Ahora sí abrir búsqueda de vuelo de vuelta
    VistaBusquedaVueloVuelta vistaVuelta = new VistaBusquedaVueloVuelta(reserva, reservaController, ocupacionRepo);
    vistaVuelta.setVisible(true);
} else {
    // Solo ida → pasar a InfoPasajeros
    VistaInfoPasajeros vistaInfo = new VistaInfoPasajeros(reserva);
    vistaInfo.setVisible(true);
}
this.dispose();

    


    }//GEN-LAST:event_btnSiguienteActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnA1;
    private javax.swing.JButton btnA2;
    private javax.swing.JButton btnA3;
    private javax.swing.JButton btnA4;
    private javax.swing.JButton btnA5;
    private javax.swing.JButton btnB1;
    private javax.swing.JButton btnB2;
    private javax.swing.JButton btnB3;
    private javax.swing.JButton btnB4;
    private javax.swing.JButton btnB5;
    private javax.swing.JButton btnC1;
    private javax.swing.JButton btnC2;
    private javax.swing.JButton btnC3;
    private javax.swing.JButton btnC4;
    private javax.swing.JButton btnC5;
    private javax.swing.JButton btnD1;
    private javax.swing.JButton btnD2;
    private javax.swing.JButton btnD3;
    private javax.swing.JButton btnD4;
    private javax.swing.JButton btnD5;
    private javax.swing.JButton btnSiguiente;
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
    private javax.swing.JTable tblAsientosIda;
    // End of variables declaration//GEN-END:variables
}
