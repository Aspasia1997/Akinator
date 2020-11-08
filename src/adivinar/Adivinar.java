
package adivinar;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;

import java.sql.*;

import java.io.*;

import java.util.Scanner;
import java.util.Random;

import java.lang.String;

import java.io.Reader;

/**
 *
 * @author Daniel
 */
public class Adivinar {

    public static void main(String[] args) {

        int cont_ask = 0;
        int cont_final = 0;
        
        boolean continuar = true;        
        
        String[] ask = new String [24];
            ask[0] = "¿Tu animal tiene pelo? (1 = SI, 0 = NO) : ";
            ask[1] = "¿Tu animal tiene plumas? (1 = SI, 0 = NO) : ";
            ask[2] = "¿Tu animal tiene huevo? (1 = SI, 0 = NO) : ";
            ask[3] = "¿Tu animal vuela? (1 = SI, 0 = NO) : ";
            ask[4] = "¿Tu animal nada? (1 = SI, 0 = NO) : ";
            ask[5] = "¿Tu animal es un depredador? (1 = SI, 0 = NO) : ";
            ask[6] = "¿Tu animal tiene dientes? (1 = SI, 0 = NO) : ";
            ask[7] = "¿Tu animal es vertebrado? (1 = SI, 0 = NO) : ";
            ask[8] = "¿Tu animal es venenoso? (1 = SI, 0 = NO) : ";
            ask[9] = "¿Tu animal tiene aletas? (1 = SI, 0 = NO) : ";
            ask[10] = "¿Cuantas patas tiene? (0,2,4,5,6,8) : ";
            ask[11] = "¿Tu animal tiene cola? (1 = SI, 0 = NO) : ";
            ask[12] = "¿Tu animal es domestico? (1 = SI, 0 = NO) : ";
            
        String[] ans = new String [18];
            ans[0] = "NA";
            ans[1] = "NA";
            ans[2] = "NA";
            ans[3] = "NA";
            ans[4] = "NA";
            ans[5] = "NA";
            ans[6] = "NA";
            ans[7] = "NA";
            ans[8] = "NA";
            ans[9] = "NA";
            ans[10] = "NA";
            ans[11] = "NA";
            ans[12] = "NA";
        
    
        do {
            try {
                
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection cn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/animals","root","");
            
            Statement st = (Statement) cn.createStatement();
            
            ResultSet rs = st.executeQuery("SELECT nombre FROM animal");
           
            Scanner sc = new Scanner(System.in);
            
            System.out.println(ask[cont_ask]);
            ans[cont_ask] = sc.nextLine();
            
            if((ans[cont_ask] == null ? ("1") == null : ans[cont_ask].equals("1")) || (ans[cont_ask] == null ? ("0") == null : ans[cont_ask].equals("0")) || (ans[10] == null ? ("2") == null : ans[10].equals("2")) || ans[10] == "4" || ans[10] == "5" || ans[10] == "6" || ans[10] == "8"){
                switch (cont_ask) {
                    case 0:
                        while(rs.next()) {
                            System.out.println(rs.getString("SELECT COUNT(*) FROM animal WHERE pelo = '" + (ans[cont_ask] + "'")));
                          
                    }
                         
                            break;
                    case 1:
                        while(rs.next()) {
                            System.out.println(rs.getString("SELECT COUNT(*) FROM animal WHERE pelo = '" + (ans[cont_ask - 1] + "' AND plumas = '") + ans[cont_ask] + "'"));
                        
                        }
                       
                            break;
                    case 2: 
                        while(rs.next()) {
                            System.out.println(rs.getString("SELECT COUNT(*) FROM animal WHERE pelo = '" + (ans[cont_ask - 2] + "' AND plumas = '")
                                    + ans[cont_ask - 1] + "'AND huevo = '") + ans[cont_ask] + "");
                          
                        }

                            break;
                    case 3:
                        while(rs.next()) {
                            System.out.println(rs.getString("SELECT COUNT(*) FROM animal WHERE pelo = '" + (ans[cont_ask - 3] + "' AND plumas = '")
                                    + ans[cont_ask - 2] + "'AND huevo = '") + ans[cont_ask - 1] + "' AND vuela = '" + ans[cont_ask] + "");
                         
                        }
                           
                            break;
                    case 4:
                        while(rs.next()) {
                            System.out.println(rs.getString("SELECT COUNT(*) FROM animal WHERE pelo = '" + (ans[cont_ask - 4] + "' AND plumas = '")
                                    + ans[cont_ask - 3] + "'AND huevo = '") + ans[cont_ask - 2] + "' AND vuela = '" + ans[cont_ask - 1] + "'AND nada = '" + ans[cont_ask] + "");
                          
                        }
                       
                            break;
                    case 5:
                        while(rs.next()) {
                            System.out.println(rs.getString("SELECT COUNT(*) FROM animal WHERE pelo = '" 
                                    + (ans[cont_ask - 5] + "' AND plumas = '")
                                    + ans[cont_ask - 4] + "'AND huevo = '") + ans[cont_ask - 3] + 
                                    "' AND vuela = '" + ans[cont_ask - 2] + "'AND nada = '" + 
                                    ans[cont_ask - 1] + "'AND depredador = '" + ans[cont_ask] + "");
                          
                        }
                          
                            break;
                    case 6:
                        while(rs.next()) {
                            System.out.println(rs.getString("SELECT COUNT(*) FROM animal WHERE pelo = '" 
                                    + (ans[cont_ask - 6] + "' AND plumas = '")
                                    + ans[cont_ask - 5] + "'AND huevo = '") + ans[cont_ask - 4] + 
                                    "' AND vuela = '" + ans[cont_ask - 3] + "'AND nada = '" + 
                                    ans[cont_ask - 2] + "'AND depredador = '" + ans[cont_ask - 1] + "'AND dientes = '" + ans[cont_ask] + "");
                        
                        }
                           
                            break;
                    case 7:
                         while(rs.next()) {
                            System.out.println(rs.getString("SELECT COUNT(*) FROM animal WHERE pelo = '" 
                                    + (ans[cont_ask - 7] + "' AND plumas = '")
                                    + ans[cont_ask - 6] + "'AND huevo = '") + ans[cont_ask - 5] + 
                                    "' AND vuela = '" + ans[cont_ask - 4] + "'AND nada = '" + 
                                    ans[cont_ask - 3] + "'AND depredador = '" + ans[cont_ask - 2] + "'AND dientes = '" 
                                    + ans[cont_ask - 1] + "'AND vertebrado = '" + ans[cont_ask] + "");
                  
                        }
                           
                            break;
                    case 8:
                         while(rs.next()) {
                            System.out.println(rs.getString("SELECT COUNT(*) FROM animal WHERE pelo = '" 
                                    + (ans[cont_ask - 8] + "' AND plumas = '")
                                    + ans[cont_ask - 7] + "'AND huevo = '") + ans[cont_ask - 6] + 
                                    "' AND vuela = '" + ans[cont_ask - 5] + "'AND nada = '" + 
                                    ans[cont_ask - 4] + "'AND depredador = '" + ans[cont_ask - 3] + "'AND dientes = '" 
                                    + ans[cont_ask - 2] + "'AND vertebrado = '" + ans[cont_ask - 1] + "'AND venenoso = '" + ans[cont_ask] + "");
                      
                        }
                           
                            break;
                    case 9:
                         while(rs.next()) {
                            System.out.println(rs.getString("SELECT COUNT(*) FROM animal WHERE pelo = '" 
                                    + (ans[cont_ask - 9] + "' AND plumas = '")
                                    + ans[cont_ask - 8] + "'AND huevo = '") + ans[cont_ask - 7] + 
                                    "' AND vuela = '" + ans[cont_ask - 6] + "'AND nada = '" + 
                                    ans[cont_ask - 5] + "'AND depredador = '" + ans[cont_ask - 4] + "'AND dientes = '" 
                                    + ans[cont_ask - 3] + "'AND vertebrado = '" + ans[cont_ask - 2] + 
                                    "'AND venenoso = '" + ans[cont_ask - 1] + "'AND aletas = '" + ans[cont_ask] + "");
                       
                        }
                       
                            break;
                    case 10:
                         while(rs.next()) {
                            System.out.println(rs.getString("SELECT COUNT(*) FROM animal WHERE pelo = '" 
                                    + (ans[cont_ask - 10] + "' AND plumas = '")
                                    + ans[cont_ask - 9] + "'AND huevo = '") + ans[cont_ask - 8] + 
                                    "' AND vuela = '" + ans[cont_ask - 7] + "'AND nada = '" + 
                                    ans[cont_ask - 6] + "'AND depredador = '" + ans[cont_ask - 5] + "'AND dientes = '" 
                                    + ans[cont_ask - 4] + "'AND vertebrado = '" + ans[cont_ask - 3] + 
                                    "'AND venenoso = '" + ans[cont_ask - 2] + "'AND aletas = '" + ans[cont_ask - 1] + "'AND patas = '" + ans[cont_ask] + "");
                   
                        }
                             
                            break;
                    case 11:
                         while(rs.next()) {
                            System.out.println(rs.getString("SELECT COUNT(*) FROM animal WHERE pelo = '" 
                                    + (ans[cont_ask - 11] + "' AND plumas = '")
                                    + ans[cont_ask - 10] + "'AND huevo = '") + ans[cont_ask - 9] + 
                                    "' AND vuela = '" + ans[cont_ask - 8] + "'AND nada = '" + 
                                    ans[cont_ask - 7] + "'AND depredador = '" + ans[cont_ask - 6] + "'AND dientes = '" 
                                    + ans[cont_ask - 5] + "'AND vertebrado = '" + ans[cont_ask - 4] + 
                                    "'AND venenoso = '" + ans[cont_ask - 3] + "'AND aletas = '" + ans[cont_ask - 2] 
                                    + "'AND patas = '" + ans[cont_ask - 1] 
                                    + "'AND cola = '" + ans[cont_ask] + "");
                  
                        }
                        
                            break;
                    case 12:
                         while(rs.next()) {
                            System.out.println(rs.getString("SELECT COUNT(*) FROM animal WHERE pelo = '" 
                                    + (ans[cont_ask - 12] + "' AND plumas = '")
                                    + ans[cont_ask - 11] + "'AND huevo = '") + ans[cont_ask - 10] + 
                                    "' AND vuela = '" + ans[cont_ask - 9] + "'AND nada = '" + 
                                    ans[cont_ask - 8] + "'AND depredador = '" + ans[cont_ask - 7] + "'AND dientes = '" 
                                    + ans[cont_ask - 6] + "'AND vertebrado = '" + ans[cont_ask - 5] + 
                                    "'AND venenoso = '" + ans[cont_ask - 4] + "'AND aletas = '" + ans[cont_ask - 3] 
                                    + "'AND patas = '" + ans[cont_ask - 2] 
                                    + "'AND cola = '" + ans[cont_ask - 1] + "'AND domestico = '" + ans[cont_ask] + "");
                        }
                            
                            break;
                    default:
                    break;
                }
                if (Integer.parseInt(rs.getString(0)) > 1) {
                    continuar = true;
                    System.out.println(("Respuesta BD " + cont_ask) + rs.next());
                    System.out.println(cont_final);
                    if(cont_final == 13) {
                        continuar = false;
                        System.out.println("Hay más de una opción para estas caracteristicas");
                    } else if ("1".equals(rs.getString(0))) {
                        continuar = false;
                        
                        switch (cont_ask) {
                            case 0:
                                while(rs.next()) {
                                System.out.println(rs.getString("SELECT nombre FROM animal WHERE pelo = '" + (ans[cont_ask] + "'")));
                                
                                }
                                break;
                  case 1:
                        while(rs.next()) {
                            System.out.println(rs.getString("SELECT nombre FROM animal WHERE pelo = '" + (ans[cont_ask - 1] + "' AND plumas = '") + ans[cont_ask] + "'"));
                            
                            
                        }
                        break;
                    case 2: 
                        while(rs.next()) {
                            System.out.println(rs.getString("SELECT nombre FROM animal WHERE pelo = '" + (ans[cont_ask - 2] + "' AND plumas = '")
                                    + ans[cont_ask - 1] + "'AND huevo = '") + ans[cont_ask] + "");
                            
                            
                        }
                        break;
                    case 3:
                        while(rs.next()) {
                            System.out.println(rs.getString("SELECT nombre FROM animal WHERE pelo = '" + (ans[cont_ask - 3] + "' AND plumas = '")
                                    + ans[cont_ask - 2] + "'AND huevo = '") + ans[cont_ask - 1] + "' AND vuela = '" + ans[cont_ask] + "");
                            
                            
                        }
                        break;
                    case 4:
                        while(rs.next()) {
                            System.out.println(rs.getString("SELECT nombre FROM animal WHERE pelo = '" + (ans[cont_ask - 4] + "' AND plumas = '")
                                    + ans[cont_ask - 3] + "'AND huevo = '") + ans[cont_ask - 2] + "' AND vuela = '" + ans[cont_ask - 1] + "'AND nada = '" + ans[cont_ask] + "");
                           
                            
                        }
                        break;
                    case 5:
                        while(rs.next()) {
                            System.out.println(rs.getString("SELECT nombre FROM animal WHERE pelo = '" 
                                    + (ans[cont_ask - 5] + "' AND plumas = '")
                                    + ans[cont_ask - 4] + "'AND huevo = '") + ans[cont_ask - 3] + 
                                    "' AND vuela = '" + ans[cont_ask - 2] + "'AND nada = '" + 
                                    ans[cont_ask - 1] + "'AND depredador = '" + ans[cont_ask] + "");
                            
                            
                        }
                        break;
                    case 6:
                        while(rs.next()) {
                            System.out.println(rs.getString("SELECT nombre FROM animal WHERE pelo = '" 
                                    + (ans[cont_ask - 6] + "' AND plumas = '")
                                    + ans[cont_ask - 5] + "'AND huevo = '") + ans[cont_ask - 4] + 
                                    "' AND vuela = '" + ans[cont_ask - 3] + "'AND nada = '" + 
                                    ans[cont_ask - 2] + "'AND depredador = '" + ans[cont_ask - 1] + "'AND dientes = '" + ans[cont_ask] + "");
                           
                           
                        } 
                        break;
                    case 7:
                         while(rs.next()) {
                            System.out.println(rs.getString("SELECT nombre FROM animal WHERE pelo = '" 
                                    + (ans[cont_ask - 7] + "' AND plumas = '")
                                    + ans[cont_ask - 6] + "'AND huevo = '") + ans[cont_ask - 5] + 
                                    "' AND vuela = '" + ans[cont_ask - 4] + "'AND nada = '" + 
                                    ans[cont_ask - 3] + "'AND depredador = '" + ans[cont_ask - 2] + "'AND dientes = '" 
                                    + ans[cont_ask - 1] + "'AND vertebrado = '" + ans[cont_ask] + "");
                           
                            
                        }
                         break;
                    case 8:
                         while(rs.next()) {
                            System.out.println(rs.getString("SELECT nombre FROM animal WHERE pelo = '" 
                                    + (ans[cont_ask - 8] + "' AND plumas = '")
                                    + ans[cont_ask - 7] + "'AND huevo = '") + ans[cont_ask - 6] + 
                                    "' AND vuela = '" + ans[cont_ask - 5] + "'AND nada = '" + 
                                    ans[cont_ask - 4] + "'AND depredador = '" + ans[cont_ask - 3] + "'AND dientes = '" 
                                    + ans[cont_ask - 2] + "'AND vertebrado = '" + ans[cont_ask - 1] + "'AND venenoso = '" + ans[cont_ask] + "");
                           
                            
                        }
                         break;
                    case 9:
                         while(rs.next()) {
                            System.out.println(rs.getString("SELECT nombre FROM animal WHERE pelo = '" 
                                    + (ans[cont_ask - 9] + "' AND plumas = '")
                                    + ans[cont_ask - 8] + "'AND huevo = '") + ans[cont_ask - 7] + 
                                    "' AND vuela = '" + ans[cont_ask - 6] + "'AND nada = '" + 
                                    ans[cont_ask - 5] + "'AND depredador = '" + ans[cont_ask - 4] + "'AND dientes = '" 
                                    + ans[cont_ask - 3] + "'AND vertebrado = '" + ans[cont_ask - 2] + 
                                    "'AND venenoso = '" + ans[cont_ask - 1] + "'AND aletas = '" + ans[cont_ask] + "");
                          
                            
                        }
                         break;
                    case 10:
                         while(rs.next()) {
                            System.out.println(rs.getString("SELECT nombre FROM animal WHERE pelo = '" 
                                    + (ans[cont_ask - 10] + "' AND plumas = '")
                                    + ans[cont_ask - 9] + "'AND huevo = '") + ans[cont_ask - 8] + 
                                    "' AND vuela = '" + ans[cont_ask - 7] + "'AND nada = '" + 
                                    ans[cont_ask - 6] + "'AND depredador = '" + ans[cont_ask - 5] + "'AND dientes = '" 
                                    + ans[cont_ask - 4] + "'AND vertebrado = '" + ans[cont_ask - 3] + 
                                    "'AND venenoso = '" + ans[cont_ask - 2] + "'AND aletas = '" + ans[cont_ask - 1] + "'AND patas = '" + ans[cont_ask] + "");
                           
                            
                        }
                         break;
                    case 11:
                         while(rs.next()) {
                            System.out.println(rs.getString("SELECT nombre FROM animal WHERE pelo = '" 
                                    + (ans[cont_ask - 11] + "' AND plumas = '")
                                    + ans[cont_ask - 10] + "'AND huevo = '") + ans[cont_ask - 9] + 
                                    "' AND vuela = '" + ans[cont_ask - 8] + "'AND nada = '" + 
                                    ans[cont_ask - 7] + "'AND depredador = '" + ans[cont_ask - 6] + "'AND dientes = '" 
                                    + ans[cont_ask - 5] + "'AND vertebrado = '" + ans[cont_ask - 4] + 
                                    "'AND venenoso = '" + ans[cont_ask - 3] + "'AND aletas = '" + ans[cont_ask - 2] 
                                    + "'AND patas = '" + ans[cont_ask - 1] 
                                    + "'AND cola = '" + ans[cont_ask] + "");
                            
                           
                        } 
                         break;
                    case 12:
                         while(rs.next()) {
                            System.out.println(rs.getString("SELECT nombre FROM animal WHERE pelo = '" 
                                    + (ans[cont_ask - 12] + "' AND plumas = '")
                                    + ans[cont_ask - 11] + "'AND huevo = '") + ans[cont_ask - 10] + 
                                    "' AND vuela = '" + ans[cont_ask - 9] + "'AND nada = '" + 
                                    ans[cont_ask - 8] + "'AND depredador = '" + ans[cont_ask - 7] + "'AND dientes = '" 
                                    + ans[cont_ask - 6] + "'AND vertebrado = '" + ans[cont_ask - 5] + 
                                    "'AND venenoso = '" + ans[cont_ask - 4] + "'AND aletas = '" + ans[cont_ask - 3] 
                                    + "'AND patas = '" + ans[cont_ask - 2] 
                                    + "'AND cola = '" + ans[cont_ask - 1] + "'AND domestico = '" + ans[cont_ask] + "");
                            }
                            break;
                    default:
                         break;
                        }
                        
                        if(rs.next()) {
                            while(rs.next()) {
                                System.out.println("Tu animal es: " + rs.getString(0));
                            }
                        }
                        
                    } else {
                        System.out.println("Lo lamento pero el animal que estas pensando no coincide con nuestra base de datos");
                        continuar = false;
                    }
                    
                }
            }
            else {
                System.out.println("No se encontraron datos.");
            }
            cn.close();
            
            } catch (Exception e) {
                System.out.println(e);
            }
            cont_ask++;
        
        } while(continuar);
        
    }
    
}
//integer.parseint()