public class Man extends Person {
    private static final int RETIREMENT_AGE = 65;

    public Man(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
    }

    @Override
    public boolean isRetired() {
        return this.age >= RETIREMENT_AGE;
    }

    @Override
    public void registerPartnership(Person partner) {
        if (partner instanceof Woman) {
            super.registerPartnership(partner);
            partner.setLastName(this.lastName);
        } else {
            throw new IllegalArgumentException("Partner must be a Woman");
        }
    }

    @Override
    public void deregisterPartnership(boolean revertLastName) {
        if (this.partner instanceof Woman && revertLastName) {
            this.partner.setLastName(((Woman) this.partner).getMaidenMane());
        }
        super.deregisterPartnership(revertLastName);
    }
}
