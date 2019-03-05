package lesson11.HomeWork;

public class BookingComAPI implements API {

    private Room[] rooms;

    public BookingComAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {

        int apartments = 0;

        for (Room room : rooms) {
            if (room.getPersons() == persons && room.getCityName() == city && room.getHotelName() == hotel) {
                if (room.getPrice() >= price - 100 && room.getPrice() <= price + 100)
                    apartments++;
            }
        }
        Room[] arrayFindRoom = new Room[apartments];

        apartments = 0;

        for (Room room : rooms) {
            if (room.getPersons() == persons && room.getCityName() == city && room.getHotelName() == hotel) {
                if (room.getPrice() >= price - 100 && room.getPrice() <= price + 100)
                    arrayFindRoom[apartments] = room;
                apartments++;
            }
        }
        return arrayFindRoom;
    }


    @Override
    public Room[] getAll() {
        return rooms;
    }
}
