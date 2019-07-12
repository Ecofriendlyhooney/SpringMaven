package badminton.skb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import badminton.skb.beans.Skb;

public class SkbDao {
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int save(Skb p) {
		String sql = "insert into skb2019(name) values('" + p.getName() + "')";
		return template.update(sql);
	}

	public int update(Skb p) {
		String sql = "update skb2019 set name='" + p.getName() + "' where id=" + p.getId() + "";
		return template.update(sql);
	}

	public int delete(int id) {
		String sql = "delete from skb2019 where id=" + id + "";
		return template.update(sql);
	}

	public Skb getSkbById(int id) {
		String sql = "select * from skb2019 where id=?";
		return template.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<Skb>(Skb.class));
	}

	public List<Skb> getSkbSchedule() {
		return template.query("select * from skb2019", new RowMapper<Skb>() {
			public Skb mapRow(ResultSet rs, int row) throws SQLException {
				Skb e = new Skb();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				return e;
			}
		});
	}
}