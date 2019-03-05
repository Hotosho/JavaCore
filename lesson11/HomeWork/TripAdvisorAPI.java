package lesson11.HomeWork;

public class TripAdvisorAPI implements API {

    private Room[] rooms;

    public TripAdvisorAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {

        int apartments = 0;
        for (Room room : rooms) {
            if (room.getCityName() == city && room.getHotelName() == hotel && room.getPrice() == price) {
                if (room.getPersons() >= persons - 1 && room.getPersons() <= persons + 1)
                    apartments++;
            }
        }
        Room[] arrayFindRoom = new Room[apartments];

        apartments = 0;

        for (Room room : rooms) {
            if (room.getCityName() == city && room.getHotelName() == hotel && room.getPrice() == price) {
                if (room.getPersons() >= persons - 1 && room.getPersons() <= persons + 1)
                    arrayFindRoom[apartments] = room;
                apartments++;
            }
        }
        return arrayFindRoom;
    }

    @Override
    public Room[] getAll() {
        return new Room[0];
    }
}
