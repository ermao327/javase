package HOME.List;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Database {

    private Map<String,Student> map = new HashMap<>();

    public void insert(Student student){
        map.putIfAbsent(student.getId(), student);
    }

    public void update(Student student){
        map.replace(student.getId(), student);
    }

    public Student selectOne(String id){
        return map.get(id);
    }

    public Collection<Student> selectAll(){
        return map.values();
    }

    public void deleteOne(String id){
        map.remove(id);
    }
}
