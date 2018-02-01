import java.util.List;
import java.util.Map;

public interface IQuery {
    long executeSQL01();
    long executeSQL02();
    long executeSQL03();
    long executeSQL04();
    List<Integer> executeSQL05();
    List<Integer> executeSQL06();
    Map<Boolean, Long> executeSQL07();
    Map<String, Long> executeSQL08();
    Map<Integer, Long> executeSQL09();
    Map<Integer, Long> executeSQL10();
    Map<String, Long> executeSQL11();
    Map<String, Long> executeSQL12();
}