<script>
  import Clock from "./Clock.svelte";
  import MiniProfile from "./MiniProfile.svelte";
  import Navigator from "./Navigator.svelte";
</script>

<aside>
  <Clock />
  <MiniProfile name="Gargesdasda" avatar="avatar.png" />
  <Navigator />
</aside>

<style>
  aside {
    gap: 8px;
    overflow: hidden;
    /* background-color: red; */
    margin-right: 8px;
    display: flex;
    flex-direction: column;
    align-items: center;
    width: 180px;
    flex-shrink: 0;
    /* min-width: 180px; */
  }
</style>
