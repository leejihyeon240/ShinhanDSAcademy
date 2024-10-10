package ch08;

public class DaoExample {

	public static void dbWork(DataAccessObject dao) {
		dao.selecet();
		dao.insert();
		dao.update();
		dao.delete();
	}

	public static void main(String[] args) {
		dbWork(new OracleDao());
		dbWork(new MySqlDao());
	}

}
