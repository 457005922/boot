package application.hbg.common.model.user;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "hbg_docter_user_info")
@EqualsAndHashCode()
public class UserEntity  implements Serializable {
    @Id
    @Column(columnDefinition = "varchar(36)  comment 'id'")
    private String id;
    @Column(columnDefinition = "varchar(36)  comment 'name'")
    private String name;
    @Column(columnDefinition = "int(36)  comment 'age'")
    private Integer age;
    @Column(columnDefinition = "varchar(36)  comment 'tel'")
    private String tel;
    @Column(columnDefinition = "varchar(36)  comment 'address'")
    private String address;
    @Column(columnDefinition = "varchar(36)  comment 'caption'")
    private String caption;
    @Column(columnDefinition = "varchar(36)  comment 'role'")
    private String role;
}
