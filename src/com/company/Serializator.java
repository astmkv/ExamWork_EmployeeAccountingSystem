package com.company;

import com.company.Firm.Firm;

import java.io.*;

public class Serializator implements Serializable {

    public boolean serialization(Object obj) {
        boolean flag = false;

        File file = new File("myFirm.data");

        ObjectOutputStream oos = null;

        try {
            FileOutputStream fos = new FileOutputStream(file);
            if (fos != null) {
                oos = new ObjectOutputStream(fos);
                oos.writeObject(obj);
                flag = true;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return flag;
    }

    public Firm deserialization() throws InvalidObjectException {

        File file = new File("myFirm.data");
        ObjectInputStream ois = null;

        FileInputStream fis = null;
        try {
            try {
                fis = new FileInputStream(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            if (fis != null) {
                try {
                    try {
                        ois = new ObjectInputStream(fis);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Firm f = (Firm) ois.readObject();
                    return f;
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }

        } finally {
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        throw new InvalidObjectException("Object fail");
    }
}