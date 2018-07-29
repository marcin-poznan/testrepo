package exam;

public class VIPUser extends User {

    Integer vipCardNumber;


    public VIPUser(String name, String lastName, String email, Integer vipCardNumber) {
        super(name, lastName, email);
        setVipCardNumber(vipCardNumber);
    }

    public Integer getVipCardNumber() {
        return vipCardNumber;
    }

    public void setVipCardNumber(Integer vipCardNumber) {
        if (checkCard(vipCardNumber)) {
            this.vipCardNumber = vipCardNumber;
        } else {
            this.vipCardNumber = null;
        }
    }

    private boolean checkCard(Integer newNumber) {
        return newNumber > 999 && newNumber % 2 == 0;
    }
}
