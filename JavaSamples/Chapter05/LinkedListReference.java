public class LinkedListReference {
  private StationList head = null;

  static class StationList {
    String name;
    StationList next = null;

    StationList(String v) {
      name = v;
    }
  }

  public LinkedListReference() {
  }

  public String get(int index) {
    if (head == null) {
      return null;
    }

    StationList cur = head;
    for (int i = 0; i < index; i++) {
      if (cur.next == null) {
        return null;
      }
      cur = cur.next;
    }
    return cur.name;
  }

  public void insHead(String val) {
    if (head == null) {
      head = new StationList(val);
      return;
    }

    StationList node = new StationList(val);
    node.next = head;
    head = node;
  }

  public void insTail(String val) {
    if (head == null) {
      head = new StationList(val);
      return;
    }

    StationList cur = head;
    while (cur.next != null) {
      cur = cur.next;
    }
    StationList node = new StationList(val);
    cur.next = node;
  }

  public void insIndex1(int index, String val) {
    if (head == null) {
      if (index == 0) {
        head = new StationList(val);
      }
      return;
    }

    StationList prev = null;
    StationList cur = head;
    for (int i = 0; i < index; i++) {
      if (cur == null) {
        return;
      }
      prev = cur;
      cur = cur.next;
    }

    StationList node = new StationList(val);
    if (prev == null) {
      node.next = head;
      head = node;
    } else if (cur == null) {
      cur = node;
      prev.next = cur;
    } else {
      prev.next = node;
      node.next = cur;
    }
  }

  public void insIndex2(int insIndex, String val, int prevInd) {
    if (head == null) {
      if (insIndex == 0) {
        head = new StationList(val);
      }
      return;
    }

    StationList prev = null;
    StationList cur = head;
    for (int i = 0; i < prevInd; i++) {
      if (cur == null) {
        return;
      }
      prev = cur;
      cur = cur.next;
    }

    StationList node = new StationList(val);
    if (prev == null) {
      node.next = head;
      head = node;
    } else if (cur == null) {
      cur = node;
      prev.next = cur;
    } else {
      prev.next = node;
      node.next = cur;
    }
  }

  public void delIndex(int index) {
    if (head == null) {
      return;
    }

    StationList prev = null;
    StationList cur = head;
    for (int i = 0; i < index; i++) {
      if (cur.next == null) {
        return;
      }
      prev = cur;
      cur = cur.next;
    }

    StationList next = cur.next;
    if (prev == null) {
      head = head.next;
    } else if (next == null) {
      prev.next = null;
    } else {
      prev.next = next;
    }
  }

  void retrieve() {
    StationList point = head;

    while (point.next != null) {
      System.out.print(point.name + " → ");
      point = point.next;
    }
    System.out.println(point.name + " → ");
  }

  public static void main(String[] args) {
    LinkedListReference obj = new LinkedListReference();
    obj.insHead("[서울]");
    obj.insTail("[천안아산]");
    obj.insTail("[대전]");
    obj.insTail("[동대구]");
    obj.insTail("[부산]");
    obj.retrieve();
    obj.insIndex2(4, "[광명]", 1);
    obj.retrieve();
    obj.delIndex(1);
    obj.retrieve();
  }
}