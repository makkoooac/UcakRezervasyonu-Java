import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Reservation {
    private Aircraft aircraft;
    private Location departure;
    private Location destination;
    private LocalDate departureDate;
    private LocalDate returnDate;
    private Customer customer;
    private int seatNumber;
    private LocalTime reservationTime;

    private static final Random random = new Random();

    public Reservation(Aircraft aircraft, Location departure, Location destination,
                       LocalDate departureDate, LocalDate returnDate, Customer customer) {
        this.aircraft = aircraft;
        this.departure = departure;
        this.destination = destination;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.customer = customer;
        this.reservationTime = generateRandomTime();
        this.seatNumber = generateRandomSeatNumber();
    }

    private LocalTime generateRandomTime() {
        int hour = random.nextInt(24);
        int minute = random.nextInt(60);
        return LocalTime.of(hour, minute);
    }

    private int generateRandomSeatNumber() {
        return random.nextInt(aircraft.getCapacity()) + 1;
    }
    
    public LocalTime getReservationTime() {
        return reservationTime;
    }
    
    public int getSeatNumber() {
        return seatNumber;
    }


    @Override
    public String toString() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String departureDateString = departureDate.format(dateFormatter);
        String returnDateString = returnDate.format(dateFormatter);
        return " - SAHİP(OWNER) = " + customer +
                "\n - UÇAK(AİRCRAFT) = " + aircraft +
                "\n - LOKASYON(LOCATİONS) = Kalkış Noktası -> " + departure + " / Varış Noktası -> " + destination +
                "\n \n - TARİH(DATE)/SAAT(TIME) = " + departureDateString + " - " + returnDateString + " - " + reservationTime +
                "\n \n - KOLTUK NO (Seat Number) = " + seatNumber +
                "\n \n >Rezervasyonunuz alınmıştır iyi uçuşlar dileriz.(Process done thanks!)" +
                "\n !! Rezervasyon bilgileriniz ve ücretler e-mail adresinize gönderilmiştir !!(Check your e-mail)";
    }
}