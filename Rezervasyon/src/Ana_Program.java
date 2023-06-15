
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class Ana_Program {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        AircraftManager aircraftManager = new AircraftManager();
        Aircraft[] aircrafts = AircraftManager.getAircrafts();

        LocationManager locationManager = new LocationManager();
        Location[] locations = LocationManager.getLocations();

        System.out.print("> Lütfen Adınızı (Name's) Girin = ");
        String name = scanner.nextLine();

        System.out.print("> Lütfen Soyadınızı (Surname's) Girin = ");
        String surname = scanner.nextLine();

        System.out.print("> Lütfen KimlikNo (ID Card's) Girin = ");
        String idCard = scanner.nextLine();

        System.out.print("> Lütfen Telefon Numaranızı (Phone Number's) Girin = ");
        String phoneNumber = scanner.nextLine();

        System.out.print("> Lütfen E-posta Adresinizi (E-mail address's) Girin = ");
        String email = scanner.nextLine();

        System.out.print("> Engeliniz Var mı (Has Special Needs - e/h ) ? (e/h): ");
        boolean hasSpecialNeeds = scanner.nextLine().equalsIgnoreCase("e");

        System.out.println("\n|Şu An Aktif Olan Uçuş Ve Havalimanı Güzergahları| \n");

        System.out.println("> Mevcut Uçuş Noktaları (Available Locations) = \n");
        for (int i = 0; i < locations.length; i++) {
            System.out.println((i + 1) + ". " + locations[i]);
        }

        Location departure;
        Location destination;

        while (true) {
            System.out.print("\n> Lütfen Kalkış Noktası Numarasını (Departure Number's) Girin = ");
            int departureIndex = Integer.parseInt(scanner.nextLine()) - 1;
            departure = locations[departureIndex];

            System.out.print("\n> Lütfen Varış Noktası Numarasını (Arrival Number's) Girin = ");
            int destinationIndex = Integer.parseInt(scanner.nextLine()) - 1;
            destination = locations[destinationIndex];

            if (departureIndex != destinationIndex) {
                break;
            }

            System.out.println("\n!!DİKKAT = Kalkış Noktası Ve Varış Noktası Aynı Olamaz Tekrar Giriniz(Mistake, Try Again).\n");
        }

        System.out.println("\n|Şu An Aktif Olan Uçaklar Ve Boş Koltuk - Hız Bilgileri| \n");

        System.out.println("> Mevcut Uçaklar (Available Aircrafts) = ");
        for (int i = 0; i < aircrafts.length; i++) {
            System.out.println((i + 1) + ". " + aircrafts[i]);
        }

        System.out.print("\n> Lütfen Uçak Tercihinizi Yapın (flight Choice's) = ");
        int aircraftIndex = Integer.parseInt(scanner.nextLine()) - 1;
        Aircraft aircraft = aircrafts[aircraftIndex];

        System.out.println("\n|TARİH(DATE)| \n");

        System.out.print("> Lütfen Gidiş Tarihini (gg.aa.yyyy) (Departure Date dd.MM.yyyy) Girin = ");
        String departureDateStr = scanner.nextLine();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate departureDate = LocalDate.parse(departureDateStr, dateFormatter);

        System.out.print("\n>Lütfen Dönüş Tarihini (gg.aa.yyyy) (Return Date dd.MM.yyyy) Girin = ");
        String returnDateStr = scanner.nextLine();
        LocalDate returnDate = LocalDate.parse(returnDateStr, dateFormatter);

        Customer customer = new Customer(name, surname, idCard, phoneNumber, email, hasSpecialNeeds);
        Reservation reservation = new Reservation(aircraft, departure, destination, departureDate, returnDate, customer);

        System.out.print("\n>Boşta Olan Koltuk Numarası (Empty Seat Number) = ");
        System.out.println(reservation.getSeatNumber());

        System.out.print("\n>Rezervasyon Saatiniz (Reservation Time) = ");
        System.out.println(reservation.getReservationTime());

        System.out.print("\n>Kabul Etmek İçin Enter'a Basın (Enter for Accept) = ");
        scanner.nextLine();

        System.out.println("\n|Rezervasyonunuz Oluşturulmuştur Aşağıda Görebilirsiniz (Reservation's Confirmed)| \n");
        System.out.println(reservation);

        scanner.close();
    }

}
