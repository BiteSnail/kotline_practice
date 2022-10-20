class RingBuffer<Element>(val size:Int) {
    private val elements = arrayOfNulls<Any>(size)
    private var read_point = 0
    private var write_point = 0

    var count: Int = 0
        private set

    fun first(): Element?{
        if (count > 0)
            return elements[read_point] as Element;
        return null;
    }

    fun write(element:Element): Boolean {
        if (count == size)
            return false
        elements.set(write_point, element);
        count++;
        write_point = (write_point+1) % size;
        return true;
    }

    fun read(): Element?{
        if (count <= 0)
            return null
        val ret = first();
        read_point = (read_point+1) % size;
        count--;
        return ret;
    }

    override fun toString(): String {
        var ret = "["
        var tmp_read_point = read_point;
        var tmp_count = count;
        while(tmp_count > 0){
            ret += " ${elements.get(tmp_read_point)}";
            tmp_read_point = (tmp_read_point+1) % size;
            tmp_count--;
        }
        ret += " ]";
        return ret;
    }
}