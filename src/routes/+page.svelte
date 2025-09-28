<script>
  import HomeApplicationLink from "../components/root/HomeApplicationLink.svelte";
</script>

<nav>
  <HomeApplicationLink
    src={"/icons/mayke_arth/chat.png"}
    alt={"mail"}
    href={"/mail"}
    text={"Mail"}
  />
  <HomeApplicationLink
    src={"/icons/mayke_arth/book-01.png"}
    alt={"contacts"}
    href={"/contacts"}
    text={"contacts"}
  />
  <HomeApplicationLink
    src={"/icons/mayke_arth/photoshop.png"}
    alt={"profile"}
    href={"/profile"}
    text={"profile"}
  />

  <HomeApplicationLink
    src={"/icons/mayke_arth/notepad-02.png"}
    alt={"notes"}
    href={"/notes"}
    text={"notes"}
  />

  <HomeApplicationLink
    src={"/icons/mayke_arth/my puter.png"}
    alt={"settings"}
    href={"/settings"}
    text={"settings"}
  />
</nav>

<style>
  nav {
    height: 100%;
    overflow: scroll;
    scroll-behavior: contain;
  }
</style>
