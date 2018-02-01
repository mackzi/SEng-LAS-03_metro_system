import java.util.List;
import java.util.Map;

public interface IQuery {
    long executeSQL01();
    long executeSQL02();
    long executeSQL03();
    long executeSQL04();
    List<Long> executeSQL05();
    List<Long> executeSQL06();
    Map<Boolean, Long> executeSQL07();
    Map<String, Long> executeSQL08();
    Map<Long, Long> executeSQL09();
    Map<Long, Long> executeSQL10();
    Map<String, Long> executeSQL11();
    Map<String, Long> executeSQL12();
}