
package utilidad.tabla;

import java.lang.reflect.Field;
import java.util.List;


public class Tabla<E> {
    public String getTable(List<E> list){
       if(list==null || list.isEmpty()) return "";
        String table="<table style='border:beige 1px solid;text-align:center'>\n";
        
        E e=list.get(0);
        Field[] campos=e.getClass().getDeclaredFields();
        
        table+="<tr style='border:beige 1px solid;text-align:center'>";
        for(Field f:campos) table+="<th>"+f.getName()+"</th>";
        table+="</tr>\n";
        
        for(E r:list){
            table+="<tr style='border:beige 1px solid;text-align:center'>";
            for(Field f:campos){
                table+="<td style='border:beige 1px solid;text-align:center'>";
                String metodo="get"
                        +f.getName().substring(0,1).toUpperCase()
                        +f.getName().substring(1);
                //table+=metodo;
                try{
                    table+=r.getClass().getDeclaredMethod(metodo, null).invoke(r, null);
                }catch(Exception ex){}
                table+="</td>";
            }
        }
        
        table+="</table>";
        return table;
    }
    
    public String getTable(List<E> list,String pagedelete){
        if(list==null || list.isEmpty()) return "";
        String table="<table style='border:beige 1px solid;text-align:center'>\n";
        
        E e=list.get(0);
        Field[] campos=e.getClass().getDeclaredFields();
        
        table+="<tr style='border:beige 1px solid;text-align:center'>";
        for(Field f:campos) table+="<th>"+f.getName()+"</th>";
        table+="<th style='border:beige 1px solid;text-align:center'>Eliminar</th>";
        table+="</tr>\n";
        
        for(E r:list){
            table+="<tr style='border:beige 1px solid;text-align:center'>";
            for(Field f:campos){
                table+="<td style='border:beige 1px solid;text-align:center'>";
                String metodo="get"
                        +f.getName().substring(0,1).toUpperCase()
                        +f.getName().substring(1);
                //table+=metodo;
                try{
                    table+=r.getClass().getDeclaredMethod(metodo, null).invoke(r, null);
                }catch(Exception ex){}
                table+="</td>";
            }
            try{
            String codEmpresa=r.getClass().getDeclaredMethod("getCodEmpresa", null).invoke(r, null).toString();
                table+="<td><a style='color:cyan;text-decoration:none' href='"+pagedelete+"?CodEmpresa="+codEmpresa+"'>Eliminar</a></td>";
            }catch(Exception ex){}
            table+="</tr>\n";
        }
        
        table+="</table>";
        return table;
    }
    
    
    
    public String getTabla( List<E> list,String page ){
        if(list==null || list.isEmpty()) return "";
        String table="<table style='border:beige 1px solid;text-align:center'>\n";
        
        E e=list.get(0);
        Field[] campos=e.getClass().getDeclaredFields();
        
        table+="<tr style='border:beige 1px solid;text-align:center'>";
        for(Field f:campos) table+="<th>"+f.getName()+"</th>";
        table+="<th style='border:beige 1px solid;text-align:center'></th>";
        table+="</tr>\n";
        
        for(E r:list){
            table+="<tr style='border:beige 1px solid;text-align:center'>";
            for(Field f:campos){
                table+="<td style='border:beige 1px solid;text-align:center'>";
                String metodo="get"
                        +f.getName().substring(0,1).toUpperCase()
                        +f.getName().substring(1);
                //table+=metodo;
                try{
                    table+=r.getClass().getDeclaredMethod(metodo, null).invoke(r, null);
                }catch(Exception ex){}
                table+="</td>";
            }
            try{
            String codEmpresa=r.getClass().getDeclaredMethod("getCodEmpresa", null).invoke(r, null).toString();
                table+="<td><a style='color:cyan;text-decoration:none' href='"+page+"?CodEmpresa="+codEmpresa+"'>Modificar Contrapartida</a></td>";
            }catch(Exception ex){}
            table+="</tr>\n";
        }
        
        table+="</table>";
        return table;
    }
    
}
