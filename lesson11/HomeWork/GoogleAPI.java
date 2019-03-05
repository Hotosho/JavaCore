package lesson11.HomeWork;

public class GoogleAPI implements API {

    private Room[] rooms;

    public GoogleAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {

        int apartments = 0;
        for (Room room : rooms) {
            if (room != null)
            if (room.getPersons() == persons && room.getPrice() == price && room.getHotelName() == hotel && room.getCityName() == city)
                apartments++;

        }
        Room[] arrayFindRoom = new Room[apartments];

        apartments = 0;

        for (Room room : rooms) {
            if (room != null)
            if (room.getPersons() == persons && room.getPrice() == price && room.getHotelName() == hotel && room.getCityName() == city)
                arrayFindRoom[apartments] = room;
            apartments++;
        }
        return arrayFindRoom;
    }

    @Override
    public Room[] getAll() {
        return new Room[0];
    }


}
