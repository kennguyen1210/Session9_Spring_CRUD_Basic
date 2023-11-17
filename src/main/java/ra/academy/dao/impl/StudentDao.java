package ra.academy.dao.impl;

import org.springframework.stereotype.Service;
import ra.academy.dao.IStudentDao;
import ra.academy.model.Student;
import ra.academy.util.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Service
public class StudentDao implements IStudentDao {
    @Override
    public List<Student> findAll() {
        Connection conn = ConnectDB.getConnection();
        List<Student> students = new ArrayList<>();
        try {
            PreparedStatement pre = conn.prepareStatement("select * from student");
            ResultSet rs = pre.executeQuery();
            while (rs.next()){
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setAge(rs.getInt("age"));
                s.setGen(rs.getBoolean("gen"));
                students.add(s);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectDB.closeConnection(conn);
        }
        return students;
    }

    @Override
    public Student findById(Integer id) {
        Connection conn = ConnectDB.getConnection();
        Student s = null;
        try {
            PreparedStatement pre = conn.prepareStatement("select * from student where id = ?");
            pre.setInt(1,id);
            ResultSet rs = pre.executeQuery();
            if (rs.next()){
                s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setAge(rs.getInt("age"));
                s.setGen(rs.getBoolean("gen"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectDB.closeConnection(conn);
        }
        return s;
    }

    @Override
    public void save(Student student) {
        Connection conn = ConnectDB.getConnection();
        if(student.getId()==null){
            // them moi
            try {
                PreparedStatement pre = conn.prepareStatement("insert into student(name,age,gen) values (?,?,?)");
                pre.setString(1,student.getName());
                pre.setInt(2,student.getAge());
                pre.setBoolean(3,student.isGen());
                pre.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                ConnectDB.closeConnection(conn);
            }
        } else {
            // cap nhat
            try {
                PreparedStatement pre = conn.prepareStatement("update student set name = ?, age = ?, gen = ? where id = ?");
                pre.setString(1,student.getName());
                pre.setInt(2,student.getAge());
                pre.setBoolean(3,student.isGen());
                pre.setInt(4,student.getId());
                pre.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                ConnectDB.closeConnection(conn);
            }
        }
    }

    @Override
    public void delete(Integer integer) {
        Connection conn = ConnectDB.getConnection();
        try {
            PreparedStatement pre = conn.prepareStatement("delete from student where id = ?");
            pre.setInt(1,integer);
            pre.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectDB.closeConnection(conn);
        }
    }
}
