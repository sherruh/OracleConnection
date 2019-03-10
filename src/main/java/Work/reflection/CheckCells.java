package Work.reflection;

import Work.Cells;

import java.lang.reflect.Field;
import java.util.List;

public class CheckCells {
    Class classCells;
    Field[] fields;

    public void checkNulls(List<Cells> cells){
       classCells=cells.get(0).getClass();
       fields=classCells.getDeclaredFields();
       for(Field field:fields){
           System.out.println(field.getName());
           System.out.println(field.getType());
           System.out.println(field.get(new Object()));
       }
    }
}
