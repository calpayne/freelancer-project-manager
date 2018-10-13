package projectmanager.models;

import java.util.Date;

/**
 *
 * @author Cal Payne
 */
public class Project {

    private String name;
    private String clientName;
    private String clientEmail;
    private String notes;
    private Date startDate;
    private Date deadline;
    private double price;
    private Priority priority;
    private int progress;

    /**
     * @param name the project name
     * @param clientName the project clients name
     * @param clientEmail the project clients email
     * @param notes the project notes
     * @param deadline the projects deadline
     * @param startDate the projects start date
     * @param price the projects price
     * @param priority the projects priority
     * @param progress the projects progress out of 100%
     */
    public Project(String name, String clientName, String clientEmail, String notes, Date startDate, Date deadline,
            double price, Priority priority, int progress) {
        this.name = name;
        this.clientName = clientName;
        this.clientEmail = clientEmail;
        this.notes = notes;
        this.startDate = startDate;
        this.deadline = deadline;
        this.price = price;
        this.priority = priority;
        this.progress = progress;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the clientName
     */
    public String getClientName() {
        return clientName;
    }

    /**
     * @param clientName the clientName to set
     */
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    /**
     * @return the clientEmail
     */
    public String getClientEmail() {
        return clientEmail;
    }

    /**
     * @param clientEmail the clientEmail to set
     */
    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    /**
     * @return the notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     * @param notes the notes to set
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * @return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the deadline
     */
    public Date getDeadline() {
        return deadline;
    }

    /**
     * @param deadline the deadline to set
     */
    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @return the price formatted
     */
    public String getFormattedPrice() {
        return String.format("£%.2f", price);
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the priority
     */
    public Priority getPriority() {
        return priority;
    }

    /**
     * @param priority the priority to set
     */
    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    /**
     * @return the progress
     */
    public int getProgress() {
        return progress;
    }

    /**
     * @param progress the progress to set
     */
    public void setProgress(int progress) {
        this.progress = progress;
    }

    /**
     * @return returns as string
     */
    @Override
    public String toString() {
        return "Name: " + getName() + "\n"
                + "Client Name: " + getClientName() + "\n"
                + "Client Email: " + getClientEmail() + "\n"
                + "Notes: " + getNotes() + "\n"
                + "Start Date: " + getStartDate().toString() + "\n"
                + "Deadline: " + getDeadline().toString() + "\n"
                + "Price: " + getFormattedPrice() + "\n"
                + "Priority: " + getPriority().toString() + "\n"
                + "Progress: " + getProgress();
    }
}
