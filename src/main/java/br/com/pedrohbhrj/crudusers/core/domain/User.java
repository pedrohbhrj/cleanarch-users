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
        if (Strings.isEmpty(firstName) || Strings.isEmpty(lastName)) {
            throw new IllegalArgumentException("First name and last name must have values");
        }
        if (id == null) {
            throw new IllegalArgumentException("Id must not be null");
        }
        if (!validateCpf(cpf)) {
            throw new IllegalArgumentException("Cpf inválid");
        }
        if (birthDayDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("You cant born in the future.");
        }
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.cpf = cpf;
        this.birthDayDate = birthDayDate;
        this.telephone = telephone;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public String getEmail() {
        return email;
    }


    public String getCpf() {
        return cpf;
    }

    public LocalDate getBirthDayDate() {
        return birthDayDate;
    }

    public String getTelephone() {
        return telephone;
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
