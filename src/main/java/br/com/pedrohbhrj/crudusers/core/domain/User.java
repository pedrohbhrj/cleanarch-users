package br.com.pedrohbhrj.crudusers.core.domain;

import org.apache.logging.log4j.util.Strings;

import java.time.LocalDate;
public class User {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String cpf;
    private LocalDate birthDayDate;
    private String telephone;

    public User(Long id, String firstName, String lastName, String email, String cpf, LocalDate birthDayDate, String telephone) {
        if(Strings.isEmpty(firstName) || Strings.isEmpty(lastName)){
            throw new IllegalArgumentException("First name and last name must have values");
        }
        if(id == null){
            throw new IllegalArgumentException("Id must not be null");
        }
        if(!validateCpf(cpf) || cpf.length() != 14){
            throw new IllegalArgumentException("Cpf inválid");
        }
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.cpf = cpf;
        this.birthDayDate = birthDayDate;
        this.telephone = telephone;
    }

    public User() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getBirthDayDate() {
        return birthDayDate;
    }

    public void setBirthDayDate(LocalDate birthDayDate) {
        this.birthDayDate = birthDayDate;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }


    private boolean validateCpf(String cpf) {
        if (cpf == null) return false;


        cpf = cpf.replaceAll("\\D", "");

        if (cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        try {
            int sum = 0;
            int weight = 10;
            for (int i = 0; i < 9; i++) {
                sum += (cpf.charAt(i) - '0') * weight--;
            }
            int digito1 = 11 - (sum % 11);
            if (digito1 > 9) digito1 = 0;
            
            sum = 0;
            weight = 11;
            for (int i = 0; i < 10; i++) {
                sum += (cpf.charAt(i) - '0') * weight--;
            }
            int digito2 = 11 - (sum % 11);
            if (digito2 > 9) digito2 = 0;

            return (cpf.charAt(9) - '0') == digito1 && (cpf.charAt(10) - '0') == digito2;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
