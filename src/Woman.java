public class Woman extends Person {
    private static final int RETIREMENT_AGE = 60;
    private String maidenName;

    public Woman(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
        this.maidenName = lastName;
    }

    public String getMaidenName() {
        return maidenName;
    }

    @Override
    public boolean isRetired() {
        return this.age >= RETIREMENT_AGE;
    }

    @Override
    public void registerPartnership(Person partner) {
        if (partner instanceof Man) {
            super.registerPartnership(partner);
            this.setLastName(partner.getLastName());
        } else {
            throw new IllegalArgumentException("Partner must be a Man");
        }
    }

    @Override
    public void deregisterPartnership(boolean revertLastName) {
        if (revertLastName) {
            this.setLastName(this.maidenName);
        }
        super.deregisterPartnership(revertLastName);
    }
}
