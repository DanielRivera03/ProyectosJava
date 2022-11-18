/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial03;

import java.util.ArrayList;

/**
 *
 * @author dany_
 */

/*
-> ELIAS DANIEL MARTINEZ RIVERA
    27 - 0077 - 2019
*/
public class Principal {
    
    // ARRAYLIST PRODUCTOS
    private ArrayList NombreProducto;
    private ArrayList CodigoProducto;
    private ArrayList MarcaProducto;
    private ArrayList CategoriaProducto;
    
    // ARRAYLIST CLIENTES
    private ArrayList NombreCliente;
    private ArrayList ApellidoCliente;
    private ArrayList DuiCliente;
    private ArrayList TelefonoCliente;
    
    // ARRAYLIST VENDEDORES
    private ArrayList NombreVendedor;
    private ArrayList ApellidoVendedor;
    private ArrayList CodigoVendedor;
    private ArrayList TelefonoVendedor;
    
    
    // CONSTRUCTOR
    public Principal(){
        
        // PRODUCTOS
        NombreProducto = new ArrayList();
        CodigoProducto = new ArrayList();
        MarcaProducto = new ArrayList();
        CategoriaProducto = new ArrayList();
        
        // LLENADO POR DEFECTO DE PRODUCTOS
        for (int indice=50; indice>=1; indice--){
            this.NombreProducto.add("Quesillo"+indice);
            this.CodigoProducto.add("qr"+indice);
            this.MarcaProducto.add("Vaquita"+indice);
            this.CategoriaProducto.add("Lacteos");
        }
        
        // CLIENTES
        NombreCliente = new ArrayList();
        ApellidoCliente = new ArrayList();
        DuiCliente = new ArrayList();
        TelefonoCliente = new ArrayList();
        
        // LLENADO POR DEFECTO DE CLIENTES
        for (int indice=50; indice>=1; indice--){
            this.NombreCliente.add("Lorem"+indice);
            this.ApellidoCliente.add("Ipsum"+indice);
            if(indice <=9){
                this.DuiCliente.add("00000000-"+indice);
                this.TelefonoCliente.add("2200-000"+indice);
            }else if ( indice >=10){
                this.DuiCliente.add("0000000-"+indice);
                this.TelefonoCliente.add("2200-00"+indice);
            }
            
        }
        
        // VENDEDORES
        NombreVendedor = new ArrayList();
        ApellidoVendedor = new ArrayList();
        CodigoVendedor = new ArrayList();
        TelefonoVendedor = new ArrayList();
        
        // LLENADO POR DEFECTO DE VENDEDORES
        for (int indice=50; indice>=1; indice--){
            this.NombreVendedor.add("Lorem"+indice);
            this.ApellidoVendedor.add("Ipsum"+indice);
            this.CodigoVendedor.add("VAQ-"+indice);
            if(indice <=9){
                this.TelefonoVendedor.add("2200-000"+indice);
            }else if ( indice >=10){
                this.TelefonoVendedor.add("2200-00"+indice);
            }
        }

    }
    
    
    // RETORNAR CANTIDAD DE ELEMENTOS GUARDADOS EN ARRAY
    public int getCantidadProductos(){
        return NombreProducto.size();
    }
    
    public int getCantidadClientes(){
        return NombreCliente.size();
    }
   
     public int getCantidadVendedores(){
        return NombreVendedor.size();
    }
    
    // -> PRODUCTOS
     
    // RETORNAR INDICE DE ARRAYS 
    public int getIndiceProductos(String nombreproducto){
        return NombreProducto.indexOf(nombreproducto);
    }
    
    public String getNombreProducto(int indice){
        return NombreProducto.get(indice).toString();
    }
    
    public String getCodigoProducto(int indice){
        return CodigoProducto.get(indice).toString();
    }
    
    public String getMarcaProducto(int indice){
        return MarcaProducto.get(indice).toString();
    }
    
    public String getCategoriaProducto(int indice){
        return CategoriaProducto.get(indice).toString();
    }
    
    // -> CLIENTES
    
    // RETORNAR INDICE DE ARRAYS 
    public int getIndiceClientes(String nombrecliente){
        return NombreCliente.indexOf(nombrecliente);
    }
    
    public String getNombreCliente(int indice){
        return NombreCliente.get(indice).toString();
    }
    
    public String getApellidoCliente(int indice){
        return ApellidoCliente.get(indice).toString();
    }
    
    public String getDuiCliente(int indice){
        return DuiCliente.get(indice).toString();
    }
    
    public String getTelefonoCliente(int indice){
        return TelefonoCliente.get(indice).toString();
    }
    
    // -> VENDEDORES
    
    // RETORNAR INDICE DE ARRAYS 
    public int getIndiceVendedor(String nombrevendedor){
        return NombreVendedor.indexOf(nombrevendedor);
    }
    
    public String getNombreVendedor(int indice){
        return NombreVendedor.get(indice).toString();
    }
    
    public String getApellidoVendedor(int indice){
        return ApellidoVendedor.get(indice).toString();
    }
    
    public String getCodigoVendedor(int indice){
        return CodigoVendedor.get(indice).toString();
    }
    
    public String getTelefonoVendedor(int indice){
        return TelefonoVendedor.get(indice).toString();
    }

}
