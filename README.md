# EzScanner
<ul>
  <li>A simple convenience class that allows you to read inputs without the awkward <code>scanner.nextLine()</code> after reading a non-string</li>
  <li>Maintains only a single <code>Scanner</code> if reading
  from <code>System.in</code> class that can be called from anywhere. This
  removes code smell of having multiple <code>new Scanner(System.in)</code> for
  no reason
  <ul>
 <li>Calls <code>getSystemInScanner()</code> to get this singleton</li>
  <ul>
  </li>
    </ul>
 
