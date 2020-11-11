package info.vladyslav.codelibrary.z_test.old;

import java.io.Serializable;
import java.util.ArrayList;

public class Z_6 {
    public static void main(String[] args) {
        ArrayList<Abonent> list = new ArrayList<Abonent>() {
            {
                add(new Abonent(87, 1658468, "Кожух Дмитрий"));
                add(new Abonent(51, 8866711, "Буйкевич Александр"));
            }
        };

        ArrayList<Abonent> list2 = new ArrayList<>();

                list2.add(new Abonent(87, 1658468, "Кожух Дмитрий"));
                list2.add(new Abonent(51, 8866711, "Буйкевич Александр"));


        System.out.println(list.get(0));
        System.out.println(list2.get(0));
    }





    }

    abstract class Entity implements Serializable, Cloneable {
        private int id;
        public Entity() {
        }
        public Entity(int id) {
            this.id = id;
        }
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
    }

    class Abonent extends Entity {
        private int phone;
        private String lastname;
        public Abonent() {
        }
        public Abonent(int id, int phone, String lastname) {
            super(id);
            this.phone = phone;
            this.lastname = lastname;
        }
        public int getPhone() {
            return phone;
        }
        public void setPhone(int phone) {
            this.phone = phone;
        }
        public String getLastname() {
            return lastname;
        }
        public void setLastname(String lastname) {
            this.lastname = lastname;
        }
        @Override
        public String toString() {
            return "Abonent [id=" + getId() + ", phone=" + phone +
                    ", lastname=" + lastname + "]";
        }
    }
