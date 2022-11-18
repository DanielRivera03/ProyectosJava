
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import laboratoriotres.Usuarios;

public class FrmPrincipal extends javax.swing.JFrame {
    // VARIABLES GLOBALES
    String correo; String nombre; String apellido; String clave; int nivel = -1;
    // VARIABLES DE CONTROL -> NUEVOS REGISTROS / EDICION DE DATOS
    boolean ComprobarNuevoRegistro = false, ComprobarEdicion = false;
    // INSTANCIA DE CLASE USUARIOS
    Usuarios usuarios;
    // CONEXION A BASE DE DATOS
    Conexion conexion;
    Connection conexionBD;
    
    // LLENADO DE JTABLE EN TIEMPO DE EJECUCION
    DefaultTableModel dibujo;
    /**
     * Creates new form FrmPrincipal
     */
    public FrmPrincipal() {
        initComponents();
        // INSTANCIA DE CONEXION
        conexion = new Conexion();
        conexionBD = conexion.getConexion();
        usuarios = new Usuarios();
        // BLOQUEO DE CAMPOS AL INICIAR EJECUCION
        BloquearElementos();
        
        
        // EFECTO DE PRUEBAS
        dibujo = new DefaultTableModel(); // INSTANCIA DE JTABLE
        // LLENADO DE INFORMACION
        dibujo.addColumn("Correos");
        dibujo.addColumn("Nombres");
        dibujo.addColumn("Apellidos");
        dibujo.addColumn("Claves");
        dibujo.addColumn("Niveles");
        
        jTable1.setModel(dibujo); // LLENADO DE COLUMNAS
        
        mostrarDatosListado();
        
        
    }
    
    
    // MOSTRAR LISTADO DE USUARIOS
    public void mostrarDatosListado(){
        dibujo.setRowCount(0);
        // LLENADO DE FILAS
        /*for(int indice = 0; indice < usuarios.getCantidadUsuarios(); indice++){
            Vector fila = new Vector();
            fila.add(usuarios.getCorreos(indice));
            fila.add(usuarios.getNombres(indice));
            fila.add(usuarios.getApellidos(indice));
            fila.add(usuarios.getClave(indice));
            //fila.add(usuarios.getNiveles(indice));
            fila.add(usuarios.getNombreNiveles(indice));
            // MOSTRAR TODOS LOS REGISTROS A USUARIOS
            dibujo.addRow(fila);
        }*/
        String consultaSQL = "CALL ListadoUsuariosRegistrados()";
        try{
            Statement consulta = conexionBD.createStatement();
            ResultSet matriz = consulta.executeQuery(consultaSQL);
            while(matriz.next()){
                Vector fila = new Vector();
                fila.add(matriz.getString("correos"));
                fila.add(matriz.getString("nombres"));
                fila.add(matriz.getString("apellidos"));
                fila.add(matriz.getString("claves"));
                fila.add(matriz.getString("descripcion"));
                dibujo.addRow(fila);
            }
            
        }catch (Exception e){
            
        }
    }
    
    
    // BLOQUEO DE TODOS LOS ELEMENTOS DE FORMULARIOS
    public void BloquearElementos(){
        // CORREO
        txtCorreos.setEditable(false);
        txtCorreos.setEnabled(false);
        
        // NOMBRES
        txtNombres.setEditable(false);
        txtNombres.setEnabled(false);
        
        // APELLIDOS
        txtApellidos.setEditable(false);
        txtApellidos.setEnabled(false);
        
        // CLAVE
        txtClave.setEditable(false);
        txtClave.setEnabled(false);
        
        // NIVEL DE USUARIO
        rdbUsuario.setEnabled(false);
        rdbAsistente.setEnabled(false);
        rdbAdministrador.setEnabled(false);
        
        // BOTON ACTUALIZAR
        btnActualizar.setEnabled(false);
    }
    
    
     // DESBLOQUEO DE TODOS LOS ELEMENTOS DE FORMULARIOS
    public void DesbloquearElementos(){
        
        // PARA EVITAR EDICION DE CAMPO UNICO
        if(btnActualizar.getText().equals("Actualizar")){
            txtCorreos.setEditable(false);
            txtCorreos.setEnabled(false);
        }else{
            txtCorreos.setEditable(true);
            txtCorreos.setEnabled(true);
        }
        
        // NOMBRES
        txtNombres.setEditable(true);
        txtNombres.setEnabled(true);
        
        // APELLIDOS
        txtApellidos.setEditable(true);
        txtApellidos.setEnabled(true);
        
        // CLAVE
        txtClave.setEditable(true);
        txtClave.setEnabled(true);
        
        // NIVEL DE USUARIOS
        rdbUsuario.setEnabled(true);
        rdbAsistente.setEnabled(true);
        rdbAdministrador.setEnabled(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        lblCorreotxt = new javax.swing.JLabel();
        lblNombretxt = new javax.swing.JLabel();
        lblApellidostxt = new javax.swing.JLabel();
        lblClavetxt = new javax.swing.JLabel();
        txtCorreos = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtClave = new javax.swing.JTextField();
        rdbUsuario = new javax.swing.JRadioButton();
        rdbAsistente = new javax.swing.JRadioButton();
        rdbAdministrador = new javax.swing.JRadioButton();
        btnBuscar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mantenimiento Usuarios");

        lblCorreotxt.setText("Correo:");

        lblNombretxt.setText("Nombres:");

        lblApellidostxt.setText("Apellidos:");

        lblClavetxt.setText("Clave:");

        buttonGroup1.add(rdbUsuario);
        rdbUsuario.setSelected(true);
        rdbUsuario.setLabel("Usuario");

        buttonGroup1.add(rdbAsistente);
        rdbAsistente.setLabel("Asistente");

        buttonGroup1.add(rdbAdministrador);
        rdbAdministrador.setLabel("Administrador");

        btnBuscar.setText("Buscar");
        btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarMouseClicked(evt);
            }
        });
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnGuardar.setText("Nuevo");
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
            }
        });
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCorreotxt)
                    .addComponent(lblNombretxt)
                    .addComponent(lblApellidostxt)
                    .addComponent(lblClavetxt))
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGuardar)
                        .addGap(128, 128, 128)
                        .addComponent(btnBuscar)
                        .addGap(108, 108, 108)
                        .addComponent(btnActualizar))
                    .addComponent(rdbAdministrador)
                    .addComponent(rdbAsistente)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdbUsuario)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtCorreos)
                                .addComponent(txtNombres)
                                .addComponent(txtApellidos)
                                .addComponent(txtClave, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCorreotxt)
                            .addComponent(txtCorreos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(96, 96, 96)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombretxt)
                            .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(81, 81, 81)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblApellidostxt)
                            .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(110, 110, 110)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblClavetxt)
                            .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addComponent(rdbUsuario))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(rdbAsistente)
                .addGap(18, 18, 18)
                .addComponent(rdbAdministrador)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(btnActualizar)
                    .addComponent(btnGuardar))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        DesbloquearElementos(); // DESBLOQUEAR ELEMENTOS DE FORMULARIO
        /*
            -> GUARDAR
        */
        // COMPROBAR SI ES UN REGISTRO NUEVO
        if(btnGuardar.getText().equals("Nuevo")){
            ComprobarNuevoRegistro = true; // CONFIRMACION DE NUEVO REGISTRO
            btnGuardar.setText("Guardar"); // -> CAMBIO BOTON NUEVO A [GUARDAR]
            btnBuscar.setText("Cancelar"); // -> CAMBIO BOTON BUSCAR A [CANCELAR]
            btnActualizar.setEnabled(false); // BLOQUEO DE BOTON ACTUALIZAR
            // HABILITAR CAMPO DE TEXTO CORREO
            txtCorreos.setEditable(true);
            txtCorreos.setEnabled(true);
        }
        // SI ES AFIRMATIVO -> PROCEDE A EJECUTAR REGISTRO DE USUARIOS
        if(ComprobarNuevoRegistro){
            // ESTABLECER FOCO EN PRIMER CAMPO DE TEXTO
            txtCorreos.requestFocus();
            setRegistroDatosCampos();
            // PARA VALIDAR ABSOLUTAMENTE TODOS LOS CAMPOS -> SI SE DESEA UN MENSAJE PERSONALIZADO POR CADA CAMPO... SE TIENE QUE VALIDAR UNO A UNO
            if(txtCorreos.getText().isEmpty() || txtNombres.getText().isEmpty() || txtApellidos.getText().isEmpty() || txtClave.getText().isEmpty()){
                JOptionPane.showMessageDialog(rootPane, "Lo sentimos, todos los campos son requeridos");   
            }else{
                // VERIFICAR SI CORREO EXISTE
                boolean estadoCorreo = usuarios.ValidarCorreo(correo);
                if(estadoCorreo){
                    JOptionPane.showMessageDialog(rootPane, "Lo sentimos, este correo ya existe");
                }else{
                    //usuarios.setRegistroNuevosUsuarios(correo, nombre, apellido, clave, nivel);
                    String consultaSQL = "";
                    consultaSQL = "CALL RegistroNuevosUsuarios('"+correo+"','"+nombre+"','"+apellido+"','"+clave+"',"+nivel+")";
                    try{
                        Statement consulta = conexionBD.createStatement();
                        boolean resultado = consulta.execute(consultaSQL);
                        if(!resultado){
                            JOptionPane.showMessageDialog(rootPane,"Enhorabuena, Registro insertado con exito");
                        }else{
                            JOptionPane.showMessageDialog(rootPane,"Registro no insertado. Lo sentimos ");
                        }
                    }catch (Exception e){
                        JOptionPane.showMessageDialog(rootPane,"Registro no insertado. Lo sentimos "+ e.getMessage());
                    }
                    setLimpiarFormulario(); // LIMPIAR DATOS
                    //JOptionPane.showMessageDialog(rootPane, "Usuario registrado con exito");
                    ComprobarNuevoRegistro = false; // -> RETORNO ESTADO DE ORIGEN VARIABLE DE CONTROL GUARDADO DE DATOS
                    btnGuardar.setText("Nuevo"); // -> CAMBIO BOTON GUARDAR A [NUEVO] -> ESTADO DE ORIGEN
                    btnBuscar.setText("Buscar"); // -> CAMBIO BOTON CANCELAR A [BUSCAR] -> ESTADO DE ORIGEN
                    BloquearElementos(); // BLOQUEO DE ELEMENTOS
                    mostrarDatosListado(); // IMPRESION EN TABLA [EFECTOS DE PRUEBAS]
                }// CIERRE if(estadoCorreo)
            }// CIERRE if(txtCorreos.getText().isEmpty() || txtNombres.getText().isEmpty() || txtApellidos.getText().isEmpty() || txtClave.getText().isEmpty())
        }// CIERRE if(ComprobarNuevoRegistro)
        /*
            -> EDITAR
        */
        // CASO CONTRARIO -> PROCEDE A EDITAR INFORMACION DE USUARIOS
        if(ComprobarEdicion){
            setRegistroDatosCampos();
            // BLOQUEAR EDICIONES SIN SEGUIMIENTO DE PROCEDIMIENTO DE BUSQUEDAS DE USUARIOS
            if(txtCorreos.getText().isEmpty() || txtNombres.getText().isEmpty() || txtApellidos.getText().isEmpty() || txtClave.getText().isEmpty()){
                JOptionPane.showMessageDialog(rootPane, "Lo sentimos, todos los campos son requeridos");   
            }else{
                // SI SE HA SEGUIDO PROCEDIMIENTO -> EFECTUAR EDICION DE DATOS
                int indiceActualizar = usuarios.getIndice(correo);
                //usuarios.ActualizarUsuario(indiceActualizar, nombre, apellido, clave, nivel);
                String consultaSQL = "";
                    consultaSQL = "CALL ModificarUsuarios('"+correo+"','"+nombre+"','"+apellido+"','"+clave+"',"+nivel+")";
                    try{
                        Statement consulta = conexionBD.createStatement();
                        boolean resultado = consulta.execute(consultaSQL);
                        if(!resultado){
                            JOptionPane.showMessageDialog(rootPane,"Enhorabuena, Registro modificado con exito");
                        }else{
                            JOptionPane.showMessageDialog(rootPane,"Registro no modificado. Lo sentimos ");
                        }
                    }catch (Exception e){
                        JOptionPane.showMessageDialog(rootPane,"Registro no modificado. Lo sentimos "+ e.getMessage());
                    }
                //JOptionPane.showMessageDialog(rootPane, "Usuario modificado con exito");
                setLimpiarFormulario(); // LIMPIEZA DE FORMULARIO
                ComprobarEdicion = false; // RETORNO ESTADO DE ORIGEN VARIABLE DE CONTROL MODIFICACION DE DATOS
                btnGuardar.setText("Nuevo"); // -> CAMBIO BOTON GUARDAR A [NUEVO] -> ESTADO DE ORIGEN
                btnBuscar.setText("Buscar"); // -> CAMBIO BOTON CANCELAR A [BUSCAR] -> ESTADO DE ORIGEN
                BloquearElementos(); // BLOQUEO DE ELEMENTOS
                mostrarDatosListado(); // IMPRESION EN TABLA [EFECTOS DE PRUEBAS]
            }// CIERRE if(txtCorreos.getText().isEmpty() || txtNombres.getText().isEmpty() || txtApellidos.getText().isEmpty() || txtClave.getText().isEmpty())
        }// CIERRE if(ComprobarEdicion)
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        // CANCELAR PROCESO -> VOLVER TODO A ESTADO DE ORIGEN
        if(btnBuscar.getText().equals("Cancelar")){
            BloquearElementos(); // BLOQUEAR ELEMENTOS
            btnBuscar.setText("Buscar");
            btnActualizar.setEnabled(true); // DESBLOQUEAR BOTON DE ACTUALIZAR DATOS
            setLimpiarFormulario(); // LIMPIAR DATOS
        }else{
            FrmBuscarUsuarios frmbusquedausuarios = new FrmBuscarUsuarios();
            frmbusquedausuarios.setVisible(true);
        }// CIERRE if(btnBuscar.getText().equals("Cancelar"))
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
         // SI ENCUENTRA CORREO -> DESBLOQUEA TODOS LOS ELEMENTOS Y HABILITA ACCIONES RESPECTIVAS PARA ESE PROCESO
         // AL MOMENTO DE PRESIONAR BOTON ACTUALIZAR
         DesbloquearElementos();
         // BLOQUEAR NUEVAMENTE BOTON ACTUALIZAR
         btnActualizar.setEnabled(false);
         // CAMBIO DE NOMBRE BOTON GUARDAR A CONFIRMAR DATOS PARA MODIFICAR 
         ComprobarEdicion = true;
         btnGuardar.setText("Confirmar");
         btnBuscar.setText("Cancelar");
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked
        // CONTROLADOR DE EVENTOS -> SI USUARIO REGISTRA O EDITA INFORMACION
        if(btnGuardar.equals("Guardar")){
            ComprobarNuevoRegistro = true; // NUEVO REGISRTRO
        }
        
        if(btnGuardar.equals("Confirmar")){
            ComprobarEdicion = true; // EDICION DE DATOS
        }
    }//GEN-LAST:event_btnGuardarMouseClicked

    // REGRESAR BOTON NUEVO A ESTADO DE ORIGEN AL MOMENTO DE PRESIONAR CANCELAR -> BOTON BUSCAR
    private void btnBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseClicked
        if(btnGuardar.getText().equals("Confirmar")){
            btnGuardar.setText("Nuevo");
            btnActualizar.setEnabled(false);
        }
    }//GEN-LAST:event_btnBuscarMouseClicked
    
    
    // OBTENER REGISTROS DE LOS INPUT FORMULARIO
    public void setRegistroDatosCampos(){
        correo = txtCorreos.getText().toString();
        nombre = txtNombres.getText().toString();
        apellido = txtApellidos.getText().toString();
        clave = txtClave.getText().toString();
        nivel = -1; // NIVEL NO DETERMINADO
        if(rdbUsuario.isSelected()){
            nivel = 1;
        }
        else if(rdbAsistente.isSelected()){
            nivel = 2;
        }
        else{
            nivel = 3;
        }
    }
    
    // LIMPIAR DATOS DE FORMULARIO
    public void setLimpiarFormulario(){
        txtCorreos.setText("");
        txtNombres.setText("");
        txtApellidos.setText("");
        txtClave.setText("");
        rdbUsuario.setSelected(true);
    }
    
    
    
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
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblApellidostxt;
    private javax.swing.JLabel lblClavetxt;
    private javax.swing.JLabel lblCorreotxt;
    private javax.swing.JLabel lblNombretxt;
    public static javax.swing.JRadioButton rdbAdministrador;
    public static javax.swing.JRadioButton rdbAsistente;
    public static javax.swing.JRadioButton rdbUsuario;
    public static javax.swing.JTextField txtApellidos;
    public static javax.swing.JTextField txtClave;
    public static javax.swing.JTextField txtCorreos;
    public static javax.swing.JTextField txtNombres;
    // End of variables declaration//GEN-END:variables
}
