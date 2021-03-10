package swt6.domain;

import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "employee_type", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("E")
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;

    @AttributeOverride(name="zipCode", column = @Column(name="address_zipCode"))
    @AttributeOverride(name="city", column = @Column(name="address_city"))
    @AttributeOverride(name="street", column = @Column(name="address_street"))

    @ManyToOne
    // multiple people could live in the same house and work in the same company
    private Address address;

    @org.hibernate.annotations.Fetch(FetchMode.SELECT)
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<LogbookEntry> logbookEntries = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "EMPL_PHONES", joinColumns = @JoinColumn(name="EMPL_ID"))
    @Column(name = "PHONE_NR")
    private Set<String> phones = new HashSet<>();

    @OneToMany
    private Set<Issue> issues = new HashSet<>();

    public Set<Issue> getIssues() { return issues; }
    public void setIssues(Set<Issue> issues) { this.issues = issues; }
    public void addIssue(Issue... issue)
    {
        for (Issue item : issue)
        {
            this.issues.add(item);
        }
    }

    public void addPhnoes(String phnoe)
    {
        phones.add(phnoe);
    }

    public Set<String> getPhones() {
        return phones;
    }

    public void setPhones(Set<String> phones) {
        this.phones = phones;
    }

    // Classes persisted with Hibernate must have a default constructor
    // (newInstance of reflection API)
    public Employee() { }

    public Employee(String firstName, String lastName, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<LogbookEntry> getLogbookEntries() {
        return logbookEntries;
    }

    public void setLogbookEntries(Set<LogbookEntry> logbookEntries) {
        this.logbookEntries = logbookEntries;
    }

    public void addLogbookEntry(LogbookEntry entry){
        if(entry.getEmployee() != null){
            entry.getEmployee().logbookEntries.remove(entry);
        }

        logbookEntries.add(entry);
        entry.setEmployee(this);
    }

    @Override
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        StringBuffer sb = new StringBuffer();
        sb.append(String.format("%d: %s, %s (%s)", id, lastName, firstName, dateOfBirth.format(fmt)));
        if(address != null){
            sb.append(", " + address);
        }
        return sb.toString();
    }
}
