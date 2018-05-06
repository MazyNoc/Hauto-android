package nu.annat.autohome.api

class Device : Comparable<Device> {
    var id: String? = null
    var name: String? = null
    var ip: String? = null
    var type: String? = null

    //    public static Comparator<Device> compareName() {
    //        return (o1, o2) -> o1.name.compareTo(o2.name);
    //    }

    override fun compareTo(device: Device): Int {
        return name!!.compareTo(device.name!!)
    }
}
