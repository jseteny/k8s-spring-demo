package hu.lippert.demo.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "person_test")
public class Person
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    public Person()
    {
    }

    public Person(String firstName, String lastName, Date birtDate)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birtDate = birtDate;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public Date getBirtDate()
    {
        return birtDate;
    }

    public void setBirtDate(Date birtDate)
    {
        this.birtDate = birtDate;
    }

    private Date birtDate;
}
