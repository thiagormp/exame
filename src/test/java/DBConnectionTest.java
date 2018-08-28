import br.com.thiago.db.DBConnection;
import org.junit.Test;

/**
 * Created by thiago on 8/27/18.
 */
public class DBConnectionTest {

    @Test
    public void testConnection(){
        DBConnection con = new DBConnection();
        con.connect();
        con.disconnect();
    }
}
