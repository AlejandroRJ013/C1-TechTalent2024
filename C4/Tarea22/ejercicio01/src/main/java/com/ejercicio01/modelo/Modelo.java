package com.ejercicio01.modelo;

import java.sql.Connection;

public class Modelo {
    private Connection conec;
    private String host;
    private String user;
    private String password;
    private int port;
    private String database;
    private String table;
    private String values;

    public Modelo() {
        conec = null;
        host = "127.0.0.1";
        user = "root";
        password = "";
        port = 3306;
        database = "";
        table = "";
        values = "";
    }

    public void setConexion(Connection conection) {
        conec = conection;
    }

    public Connection getConexion() {
        return conec;
    }

    public void setHost(String hostName) {
        host = hostName;
    }

    public String getHost() {
        return host;
    }

    public void setUser(String userName) {
        user = userName;
    }

    public String getUser() {
        return user;
    }

    public void setPassword(String passwordName) {
        password = passwordName;
    }

    public String getPassword() {
        return password;
    }

    public void setPort(int portName) {
        port = portName;
    }

    public int getPort() {
        return port;
    }

    public void setDatabase(String databaseName) {
        database = databaseName;
    }

    public String getDatabase() {
        return database;
    }

    public void setTable(String tableName) {
        table = tableName;
    }

    public String getTable() {
        return table;
    }

    public void setValues(String newValues) {
        values = newValues;
    }

    public String getValues() {
        return values;
    }
}